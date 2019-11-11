package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.*;
import com.nutritech.nu34life.repository.DietRepository;
import com.nutritech.nu34life.service.DietService;
@Service
public class DietServiceImpl implements DietService {

	@Autowired
	private DietRepository dietRepository;
	
	@Override
	public Diet save(Diet entity) {
		return dietRepository.save(entity);
	}

	@Override
	public Optional<Diet> findById(Long id) {
		return dietRepository.findById(id);
	}

	@Override
	public List<Diet> findAll() {
		// TODO Auto-generated method stub
		return dietRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dietRepository.deleteById(id);
	}

}
