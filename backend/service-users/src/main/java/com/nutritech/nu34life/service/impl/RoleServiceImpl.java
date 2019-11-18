package com.nutritech.nu34life.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.Role;
import com.nutritech.nu34life.model.repository.RoleRepository;
import com.nutritech.nu34life.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role saveAndUpdate(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}
	
	
}
