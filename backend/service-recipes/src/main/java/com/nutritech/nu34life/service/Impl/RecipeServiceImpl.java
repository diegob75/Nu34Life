package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.Mapper;
import com.nutritech.nu34life.api.viewmodel.RecipeViewModel;
import com.nutritech.nu34life.model.entity.Recipe;
import com.nutritech.nu34life.model.repository.RecipeRepository;
import com.nutritech.nu34life.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private Mapper mapper;
	
	@Override
	public Recipe create(Recipe entity) {
		// TODO Auto-generated method stub
		return null;
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
	public List<RecipeViewModel> getByNameLike(String string){
		List<RecipeViewModel> recipes = recipeRepository.findByNameContainingIgnoreCase(string)
									.stream()
									.map(recipe -> this.mapper.convertToRecipeViewModel(recipe))
									.collect(Collectors.toList());
		
		return recipes;
	}

}
