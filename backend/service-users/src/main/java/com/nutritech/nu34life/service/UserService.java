package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.model.entity.Account;

public interface UserService {
	
	Account getByUsername(String username);
	
	List<Account> getUsers();
	
	Account updateAndCreate(Account requestBody);
	
	
}
