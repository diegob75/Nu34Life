package com.nutritech.nu34life.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.client.EmailFeignClient;
import com.nutritech.nu34life.client.ProfileFeignClient;
import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.model.entity.Role;
import com.nutritech.nu34life.model.repository.UserRepository;
import com.nutritech.nu34life.service.UserService;
import com.nutritech.nu34life.util.Email;
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
	private EmailFeignClient emailService;
	
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
		
		Email email = new Email();
		email.setHeader("Registro Exitoso!!");
		email.setCuerpo("<h3>Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.</h3>\n <p>Con nombre de usuario : "+request.getUsername()+".</p><a href=\"http://localhost:8090/api/service-users/users/validateEmail/"+account.getId()+"\">Activa tu cuenta dando click aqui!</a>");
		email.setSendTo(request.getEmail());
		System.out.println(email.toString());
		emailService.sendEmail(email);
	
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
		
		Email email = new Email();
		email.setHeader("Registro Exitoso!!");
		email.setCuerpo("<h3>Enhorabuena "+request.getFirstName()+" "+request.getLastName()+" su cuenta se ha registrado correctamente.</h3>\n <p>Con nombre de usuario : "+request.getUsername()+".</p><a href=\"http://localhost:8090/api/service-users/users/validateEmail/"+account.getId()+"\">Activa tu cuenta dando click aqui!</a>");
		email.setSendTo(request.getEmail());
		System.out.println(email.toString());
		emailService.sendEmail(email);
		
		return account;
	}
	@Transactional
	@Override
	public Boolean validateUser(Long id) {
		// TODO Auto-generated method stub
		return (userRepository.validateEmail(id))>0;
	}

	@Override
	public Account updateAccount(UserRequest requestBody) {
		// TODO Auto-generated method stub
		Account account = userRepository.findByUsername(requestBody.getUsername());
		account.setPassword(passwordEncoder.encode(requestBody.getPassword()));
		return userRepository.save(account);
	}

	@Override
	public Account createPatient(UserRequest requestBody) {
		Account account = new Account();
		Role role = new Role();
		role.setId(Long.valueOf(2));
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		account.setRoles(roles);
		account.setRegisterDate(LocalDate.now());
		account.setEmailValidated(false);
		account.setAccountStatus(1);
		account.setPassword(passwordEncoder.encode(requestBody.getPassword()));
		account.setEmail(requestBody.getEmail());
		account.setUsername(requestBody.getUsername());
		
		account = userRepository.save(account);
		account.setPassword("**************************");
		Patient patient = new Patient();
		
		patient.setFirstName(requestBody.getFirstName());
		patient.setLastName(requestBody.getLastName());
		patient.setImagen(requestBody.getImagen());
		patient.setUserId(account.getId());
		patient.setHeight(requestBody.getHeight());
		patient.setWeight(requestBody.getWeight());		
		
		patient = profileFeignClient.savePatient(patient);
		
		profileFeignClient.requestAffiliation(patient.getId(), requestBody.getUserId());
		
		Email email = new Email();
		email.setHeader("Registro Exitoso!!");
		email.setCuerpo("<h3>Enhorabuena "+requestBody.getFirstName()+" "+requestBody.getLastName()+" su cuenta se ha registrado correctamente.</h3>\n <p>Con nombre de usuario : "+requestBody.getUsername()+".</p><p>Contraseña : "+requestBody.getPassword()+".</p><a href=\"http://localhost:8090/api/service-users/users/validateEmail/"+account.getId()+"\">Activa tu cuenta dando click aqui!</a>"+"<p>Si desea activar su nutricionista acceda a  : </p>"+"<a href=\"localhost:8090/service-profiles/patients/affiliate/confirm/?id="+account.getId()+"&patientId="+patient.getId()+"\"</a>");
		email.setSendTo(requestBody.getEmail());
		System.out.println(email.toString());
		emailService.sendEmail(email);
		
		return account;
	}

}
