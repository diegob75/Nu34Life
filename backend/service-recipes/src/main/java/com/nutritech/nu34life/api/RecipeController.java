package com.nutritech.nu34life.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.Mapper;
import com.nutritech.nu34life.api.viewmodel.*;
import com.nutritech.nu34life.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private Mapper mapper;

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	public List<RecipeViewModel> getRecipes() {
		List<RecipeViewModel> recipes = recipeService.getAll()
				.stream()
				.map(recipe -> this.mapper.convertToRecipeViewModel(recipe))
				.collect(Collectors.toList());
		
		return recipes;
	}
	
	@GetMapping("/{id}")
	public RecipeViewModel getRecipeById(@PathVariable Long id) {
		RecipeViewModel viewModel = this.mapper.convertToRecipeViewModel(recipeService.getOne(id).get());
		return viewModel;
	}
}
