package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.util.UserRequest;
import com.nutritech.nu34life.util.UserResponse;

public interface UserService {
	
	UserResponse getByUsername(String username);
	
	List<Account> getUsers();
	
	Account updateAndCreateNutritionist(UserRequest requestBody);
	
	Account updateAndCreatePatient(UserRequest requestBody);
	
	Account createPatient(UserRequest requestBody);
	
	Boolean validateUser(Long id);
	
	Account updateAccount(UserRequest requestBody);
	
}
