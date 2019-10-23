package com.nutritech.nu34life.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.Recipe;
import com.nutritech.nu34life.model.repository.RecipeRepository;
import com.nutritech.nu34life.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe create(Recipe entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Recipe> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
