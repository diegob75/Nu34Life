package com.nutritech.nu34life.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.entity.*;
import com.nutritech.nu34life.repository.MealRepository;
import com.nutritech.nu34life.service.MealService;
@Service
public class MealServiceImpl implements MealService{

	@Autowired
	private MealRepository mealRepository;
	@Override
	public Meal save(Meal entity) {
		// TODO Auto-generated method stub
		return mealRepository.save(entity);
	}

	@Override
	public Optional<Meal> findById(Long id) {
		// TODO Auto-generated method stub
		return mealRepository.findById(id);
	}

	@Override
	public List<Meal> findAll() {
		// TODO Auto-generated method stub
		return mealRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		mealRepository.deleteById(id);
	}

}
