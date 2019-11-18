package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.model.entity.Role;
import com.nutritech.nu34life.service.RoleService;

@RestController
@RequestMapping(path="/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
		
	@GetMapping
	public List<Role> getAll(){
		return roleService.getAll();
	}
	
	@PostMapping
	public Role registerRole(@RequestBody Role requestBody)
	{
		return roleService.saveAndUpdate(requestBody);
	}
}