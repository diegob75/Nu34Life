package com.nutritech.nu34life.service;

import com.nutritech.nu34life.util.UserResponse;

public interface UserService {
	public UserResponse findByUsername(String username);
}
