package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.model.entity.Role;

public interface RoleService {
	Role getById(Long id);
	
	List<Role> getAll();
	
	Role saveAndUpdate(Role role);
}
