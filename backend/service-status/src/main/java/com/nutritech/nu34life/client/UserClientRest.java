package com.nutritech.nu34life.client;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.nutritech.nu34life.model.entity.User;

@Component
public class UserClientRest {
	
	User[] users = {
		new User(Long.valueOf(1), "admin"),
		new User(Long.valueOf(2), "nutri1"),
		new User(Long.valueOf(3), "patient")
	};
	
	public User findById(Long id) {
		return Arrays.asList(users).stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
	}
}
