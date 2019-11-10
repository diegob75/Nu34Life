package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.*;
import com.nutritech.nu34life.repository.DietDayDetailRepository;
import com.nutritech.nu34life.service.DietDayDetailService;

@Service
public class DietDayDetailServiceImpl implements DietDayDetailService{

	@Autowired
	private DietDayDetailRepository dietDayDetailRepository;
	@Override
	public DietDayDetail save(DietDayDetail entity) {
		// TODO Auto-generated method stub
		return dietDayDetailRepository.save(entity);
	}

	@Override
	public Optional<DietDayDetail> findById(Long id) {
		// TODO Auto-generated method stub
		return dietDayDetailRepository.findById(id);
	}

	@Override
	public List<DietDayDetail> findAll() {
		// TODO Auto-generated method stub
		return dietDayDetailRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dietDayDetailRepository.deleteById(id);
	}

}
