package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.client.FoodClientRest;
import com.nutritech.nu34life.client.UserClientRest;
import com.nutritech.nu34life.model.entity.*;
import com.nutritech.nu34life.model.repository.*;
import com.nutritech.nu34life.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;
	@Autowired
	FoodClientRest foodClientRest;
	@Autowired
	UserClientRest userClientRest;
	
	@Override
	@Transactional
	public PatientState save(PatientState entity) {
		
		
		entity.getAllergies().iterator().forEachRemaining(x -> {
			x.setState(entity);
			x.getId().setStateId(entity.getId());
			});
		entity.getDrugs().iterator().forEachRemaining(x -> {
			x.setState(entity);
			x.getId().setStateId(entity.getId());
			});
    	entity.getConditions().iterator().forEachRemaining(x -> {
			x.setState(entity);
			x.getId().setStateId(entity.getId());
			});
    	entity.getActivities().iterator().forEachRemaining(x -> {
			x.setState(entity);
			x.getId().setStateId(entity.getId());
			});
		return stateRepository.save(entity);
	}

	@Override
	public Optional<PatientState> findById(Long id) {
		return stateRepository.findById(id);
	}

	@Override
	public List<PatientState> findAll() {
		throw new NotImplementedException();
	}

	@Override
	public void delete(Long id) {
		throw new NotImplementedException();

	}

	@Override
	public List<PatientState> findPatientHistory(Long id) {
		return stateRepository.findPatientHistory(id);
	}

	@Override
	public Optional<PatientState> findPatientLastState(Long id) {
		return stateRepository.findPatientHistory(id).stream()
				.findFirst();
	}
}
