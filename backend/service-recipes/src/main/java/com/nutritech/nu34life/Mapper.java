package com.nutritech.nu34life;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nutritech.nu34life.api.viewmodel.IngredientViewModel;
import com.nutritech.nu34life.api.viewmodel.RecipeViewModel;
import com.nutritech.nu34life.model.entity.Ingredient;
import com.nutritech.nu34life.model.entity.Recipe;

@Component
public class Mapper {
	
	public IngredientViewModel convertToIngredientViewModel(Ingredient entity) {
		
		IngredientViewModel viewModel = new IngredientViewModel();
		
		viewModel.setFood(entity.getFood());
		viewModel.setNutrFact(entity.getNutrFact());
		viewModel.setQuantity(entity.getQuantity());
		viewModel.setUnit(entity.getUnit());
		viewModel.setRecipeId(entity.getRecipe().getId());
		
		return viewModel;
	}
	
	public RecipeViewModel convertToRecipeViewModel(Recipe entity) {
		
		RecipeViewModel viewModel = new RecipeViewModel();
		viewModel.setId(entity.getId());
		viewModel.setIngredient(entity.getIngredients()
				.stream()
				.map(ingredient -> convertToIngredientViewModel(ingredient))
				.collect(Collectors.toList()));
		viewModel.setName(entity.getName());
		viewModel.setServings(entity.getServings());
		viewModel.setSteps(entity.getSteps());
		
		return viewModel;
	}
	
}
