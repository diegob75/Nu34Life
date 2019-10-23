package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.MedicalCondition;
import com.nutritech.nu34life.model.repository.MedicalConditionRepository;
import com.nutritech.nu34life.service.MedicalConditionService;

@Service
public class MedicalConditionServiceImpl implements MedicalConditionService {

	@Autowired
	MedicalConditionRepository conditionRepository;
	
	@Override
	public MedicalCondition save(MedicalCondition entity) {
		throw new NotImplementedException();
	}

	@Override
	public Optional<MedicalCondition> findById(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public List<MedicalCondition> findAll() {
		return conditionRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		throw new NotImplementedException();
	}

}
