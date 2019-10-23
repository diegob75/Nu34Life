package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.Food;
import com.nutritech.nu34life.model.repository.FoodRepository;
import com.nutritech.nu34life.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository foodRepository;
	
	@Transactional
	@Override
	public Food create(Food entity) {
		return foodRepository.save(entity);
	}

	@Override
	public List<Food> getAll() {
		List<Food> foods = new ArrayList<>();
		foodRepository.findAll().iterator().forEachRemaining(foods::add);
		return foods;
	}

	@Override
	public Optional<Food> getOne(Long id) {
		return foodRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		foodRepository.deleteById(id);
	}

}
