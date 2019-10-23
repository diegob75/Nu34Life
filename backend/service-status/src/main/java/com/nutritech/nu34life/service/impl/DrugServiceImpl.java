package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.Drug;
import com.nutritech.nu34life.model.repository.DrugRepository;
import com.nutritech.nu34life.service.DrugService;

@Service
public class DrugServiceImpl implements DrugService {
	
	@Autowired
	DrugRepository drugRepository;
	
	@Override
	public Drug save(Drug entity) {
		throw new NotImplementedException();
	}

	@Override
	public Optional<Drug> findById(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public List<Drug> findAll() {
		return drugRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		throw new NotImplementedException();
	}

}
