package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.*;
import com.nutritech.nu34life.repository.DietDayRepository;
import com.nutritech.nu34life.service.DietDayService;
@Service
public class DietDayServiceImpl implements DietDayService{

	@Autowired
	private DietDayRepository dietDayRepository;
	
	@Override
	public DietDay save(DietDay entity) {
		// TODO Auto-generated method stub
		
		return dietDayRepository.save(entity);
	}

	@Override
	public Optional<DietDay> findById(Long id) {
		// TODO Auto-generated method stub
		return dietDayRepository.findById(id);
	}

	@Override
	public List<DietDay> findAll() {
		// TODO Auto-generated method stub
		
		return dietDayRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dietDayRepository.deleteById(id);
		
	}

}
