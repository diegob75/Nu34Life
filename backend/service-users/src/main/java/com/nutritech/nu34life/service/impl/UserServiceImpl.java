package com.nutritech.nu34life.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.client.ProfileFeignClient;
import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.model.entity.Role;
import com.nutritech.nu34life.model.repository.UserRepository;
import com.nutritech.nu34life.service.UserService;
import com.nutritech.nu34life.util.Nutritionist;
import com.nutritech.nu34life.util.Patient;
import com.nutritech.nu34life.util.UserRequest;
import com.nutritech.nu34life.util.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProfileFeignClient profileFeignClient;
	@Autowired
	private EmailService emailService;
	
	@Override
	public UserResponse getByUsername(String username) {
		// TODO Auto-generated method stub
		UserResponse response = new UserResponse();
		Account account = userRepository.findByUsername(username);
		if(account == null)return null;
		response.setEmail(account.getEmail());
		response.setPassword(account.getPassword());
		response.setUsername(account.getUsername());
		response.setUserId(account.getId());
		response.setRegisterDate(account.getRegisterDate());
		response.setEmailValidated(account.getEmailValidated());
		response.setAccountStatus(account.getAccountStatus());
		response.setRoles(account.getRoles());
		Nutritionist nutritionist = profileFeignClient.getByUserId(account.getId());
		if(nutritionist != null) {
			response.setProfileCreated(Boolean.TRUE);
			response.setFirstName(nutritionist.getFirstName());
			response.setLastName(nutritionist.getLastName());
			response.setImagen(nutritionist.getImagen());
			response.setProfileId(nutritionist.getId());
		}else {
			response.setProfileCreated(Boolean.FALSE);
		}
		
		return response;
	}

	@Override
	public List<Account> getUsers() {
		// TODO Auto-generated method stub
		List<Account> accounts = userRepository.findAll();
		for(Account i : accounts) {
			i.setPassword("**************************");
		}
		return accounts;
	}

	@Override
	public Account updateAndCreateNutritionist(UserRequest request) {
		// TODO Auto-generated method stub
		Account account = new Account();
		Role role = new Role();
		role.setId(Long.valueOf(1));
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		account.setRoles(roles);
		account.setRegisterDate(LocalDate.now());
		account.setEmailValidated(false);
		account.setAccountStatus(1);
		account.setPassword(passwordEncoder.encode(request.getPassword()));
		account.setEmail(request.getEmail());
		account.setUsername(request.getUsername());
		
		account = userRepository.save(account);
		account.setPassword("**************************");
		Nutritionist nutritionist = new Nutritionist();
		
		nutritionist.setFirstName(request.getFirstName());
		nutritionist.setLastName(request.getLastName());
		nutritionist.setImagen(request.getImagen());
		nutritionist.setUserId(account.getId());
		profileFeignClient.saveNutritionist(nutritionist);
		

		System.out.println("Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.\n Con nombre de usuario : "+request.getUsername()+"\n Y contrasena : na mentira xd.");
		emailService.sendEmail("Registro Exitoso !!", "<h3>Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.</h3>\n <p>Con nombre de usuario : "+request.getUsername()+".</p>", request.getEmail());
		System.out.println("Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.\n Con nombre de usuario : "+request.getUsername()+"\n Y contrasena : na mentira xd.");
		return account;
	}
	@Override
	public Account updateAndCreatePatient(UserRequest request) {
		Account account = new Account();
		Role role = new Role();
		role.setId(Long.valueOf(2));
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		account.setRoles(roles);
		account.setRegisterDate(LocalDate.now());
		account.setEmailValidated(false);
		account.setAccountStatus(1);
		account.setPassword(passwordEncoder.encode(request.getPassword()));
		account.setEmail(request.getEmail());
		account.setUsername(request.getUsername());
		
		account = userRepository.save(account);
		account.setPassword("**************************");
		Patient patient = new Patient();
		
		patient.setFirstName(request.getFirstName());
		patient.setLastName(request.getLastName());
		patient.setImagen(request.getImagen());
		patient.setUserId(account.getId());
		patient.setHeight(request.getHeight());
		patient.setWeight(request.getWeight());
		profileFeignClient.savePatient(patient);
		System.out.println("Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.\n Con nombre de usuario : "+request.getUsername()+"\n Y contrasena : na mentira xd.");
		emailService.sendEmail("Registro Exitoso !!", "<h3>Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.</h3>\n <p>Con nombre de usuario : "+request.getUsername()+".</p>", request.getEmail());
		System.out.println("Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.\n Con nombre de usuario : "+request.getUsername()+"\n Y contrasena : na mentira xd.");
		return account;
	}

}
