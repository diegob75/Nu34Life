package com.nutritech.nu34life.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.Nutritionist;
import com.nutritech.nu34life.repository.NutritionistRepository;
import com.nutritech.nu34life.service.NutritionistService;

@Service
public class NutritionistServiceImpl implements NutritionistService {

	@Autowired
	private NutritionistRepository nutritionistRepository;
	
	@Override
	public Nutritionist getById(Long id) {
		// TODO Auto-generated method stub
		return nutritionistRepository.findById(id).get();
	}

	@Override
	public List<Nutritionist> getAll() {
		// TODO Auto-generated method stub
		return nutritionistRepository.findAll();
	}

	@Override
	public Nutritionist save(Nutritionist entity) {
		// TODO Auto-generated method stub
		return nutritionistRepository.save(entity);
	}

	@Override
	public Nutritionist findByUserId(Long id) {
		// TODO Auto-generated method stub
		return nutritionistRepository.findByUserId(id);
	}

}
