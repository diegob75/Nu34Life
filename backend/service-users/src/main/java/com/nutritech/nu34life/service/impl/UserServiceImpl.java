package com.nutritech.nu34life.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.model.entity.Role;
import com.nutritech.nu34life.model.repository.UserRepository;
import com.nutritech.nu34life.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Account getByUsername(String username) {
		// TODO Auto-generated method stub
		Account account = userRepository.findByUsername(username);

		account.setPassword("**************************");
		return account;
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
	public Account updateAndCreate(Account account) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setId(Long.valueOf(1));
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		account.setRoles(roles);
		account.setRegisterDate(new Date());
		account.setEmailValidated(false);
		account.setAccountStatus(1);
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		
		account = userRepository.save(account);
		account.setPassword("**************************");
		return account;
	}

}
