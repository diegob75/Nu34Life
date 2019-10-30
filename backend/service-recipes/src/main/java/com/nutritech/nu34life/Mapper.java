package com.nutritech.nu34life;

import org.springframework.stereotype.Component;

import com.nutritech.nu34life.api.viewmodel.RecipeViewModel;
import com.nutritech.entity.Recipe;

@Component
public class Mapper {
	

	public RecipeViewModel convertToRecipeViewModel(Recipe entity) {
		
		RecipeViewModel viewModel = new RecipeViewModel();
		viewModel.setId(entity.getId());
		viewModel.setName(entity.getName());
		viewModel.setMainIngredient(entity.getIngredients().get(0).getFood().getName());
		viewModel.setEnergeticValue(entity.getNutrFact().getEnergeticValue());
		
		return viewModel;
	}
	
}
