package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.Goal;
import com.nutritech.nu34life.model.repository.GoalRepository;

@Service
public class GoalServiceImpl implements com.nutritech.nu34life.service.GoalService {

	@Autowired
	GoalRepository goalRepository;
	
	@Override
	public Goal save(Goal entity) {
		throw new NotImplementedException();
	}

	@Override
	public Optional<Goal> findById(Integer id) {
		throw new NotImplementedException();
	}

	@Override
	public List<Goal> findAll() {
		return goalRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		throw new NotImplementedException();
	}

}
