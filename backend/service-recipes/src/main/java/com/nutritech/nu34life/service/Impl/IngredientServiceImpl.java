package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.*;
import com.nutritech.nu34life.model.repository.IngredientRepository;
import com.nutritech.nu34life.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService{

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Transactional
	@Override
	public Ingredient create(Ingredient entity) {
		return ingredientRepository.save(entity);
	}

	@Override
	public List<Ingredient> getAll() {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().iterator().forEachRemaining(ingredients::add);
		return ingredients;
	}

	@Override
	public Optional<Ingredient> getOne(Long id) {
		return ingredientRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		ingredientRepository.deleteById(id);
	}

}
