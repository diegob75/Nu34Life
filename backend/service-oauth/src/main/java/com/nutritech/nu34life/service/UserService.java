package com.nutritech.nu34life.service;

import com.nutritech.nu34life.model.entity.Account;

public interface UserService {
	public Account findByUsername(String username);
}
