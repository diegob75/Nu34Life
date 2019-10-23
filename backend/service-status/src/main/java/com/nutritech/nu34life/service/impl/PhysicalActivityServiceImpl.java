package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.PhysicalActivity;
import com.nutritech.nu34life.model.repository.PhysicalActivityRepository;
import com.nutritech.nu34life.service.PhysicalActivityService;

@Service
public class PhysicalActivityServiceImpl implements PhysicalActivityService {

	@Autowired
	PhysicalActivityRepository activityRepository;
	
	@Override
	public PhysicalActivity save(PhysicalActivity entity) {
		throw new NotImplementedException();
	}

	@Override
	public Optional<PhysicalActivity> findById(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public List<PhysicalActivity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		throw new NotImplementedException();
	}

}
