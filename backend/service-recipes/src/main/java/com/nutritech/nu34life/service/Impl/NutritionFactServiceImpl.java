package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.entity.NutritionFact;
import com.nutritech.nu34life.model.repository.NutritionFactRepository;
import com.nutritech.nu34life.service.NutritionFactService;

@Service
public class NutritionFactServiceImpl implements NutritionFactService{

	@Autowired
	private NutritionFactRepository nutritionfactRepository;
	
	@Transactional
	@Override
	public NutritionFact create(NutritionFact entity) {
		return nutritionfactRepository.save(entity);
	}

	@Override
	public List<NutritionFact> getAll() {
		List<NutritionFact> nutrifacts = new ArrayList<>();
		nutritionfactRepository.findAll().iterator().forEachRemaining(nutrifacts::add);
		return nutrifacts;
	}

	@Override
	public Optional<NutritionFact> getOne(Long id) {
		return nutritionfactRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		nutritionfactRepository.deleteById(id);
	}

}
