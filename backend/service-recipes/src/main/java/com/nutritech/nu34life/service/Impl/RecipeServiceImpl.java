package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.*;
import com.nutritech.nu34life.model.repository.RecipeRepository;
import com.nutritech.nu34life.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe create(Recipe entity) {
		// TODO Auto-generated method stub
		
		return recipeRepository.save(entity);
	}

	@Override
	public List<Recipe> getAll() {
		List<Recipe> recipes = new ArrayList<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

	@Override
	public Optional<Recipe> getOne(Long id) {
		return recipeRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Recipe> getByNameLike(String string){
		List<Recipe> recipes = recipeRepository.findByNameContainingIgnoreCase(string);
		
		return recipes;
	}

}
