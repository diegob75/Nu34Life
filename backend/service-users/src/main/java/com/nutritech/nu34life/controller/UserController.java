package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.model.entity.Account;
import com.nutritech.nu34life.service.UserService;
import com.nutritech.nu34life.util.UserRequest;
import com.nutritech.nu34life.util.UserResponse;

@RestController
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(path="/getByUserName")
	UserResponse getByUsername(@RequestParam String username){
		return userService.getByUsername(username);
	}
	
	@GetMapping
	List<Account> getAll(){
		return userService.getUsers();
	}
	
	@PostMapping(path="/registerNutritionist")
	Account registerNutritionist(@RequestBody UserRequest requestBody)
	{
		return userService.updateAndCreateNutritionist(requestBody);
	}
	@PostMapping(path="/registerPatient")
	Account registerPatient(@RequestBody UserRequest requestBody)
	{
		return userService.updateAndCreatePatient(requestBody);
	}
	
	@GetMapping(path="/validateEmail/{id}")
	Boolean validateEmail(@PathVariable Long id) {
		return userService.validateUser(id);
	}
}
