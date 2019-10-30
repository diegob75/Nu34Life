package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.entity.Step;
import com.nutritech.nu34life.model.repository.StepRepository;
import com.nutritech.nu34life.service.StepService;

@Service
public class StepServiceImpl implements StepService{

	@Autowired
	private StepRepository stepRepository;
	
	@Transactional
	@Override
	public Step create(Step entity) {
		return stepRepository.save(entity);
	}

	@Override
	public List<Step> getAll() {
		List<Step> steps = new ArrayList<>();
		stepRepository.findAll().iterator().forEachRemaining(steps::add);
		return steps;
	}

	@Override
	public Optional<Step> getOne(Long id) {
		return stepRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		stepRepository.deleteById(id);
	}

}
