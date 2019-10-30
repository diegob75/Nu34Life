package com.nutritech.nu34life;

import org.springframework.stereotype.Component;

import com.nutritech.entity.Recipe;
import com.nutritech.nu34life.api.viewmodel.DietDayViewModel;

@Component
public class Mapper {
	

	public DietDayViewModel convertToRecipeViewModel(Recipe entity) {
		
    DietDayViewModel viewModel = new DietDayViewModel();
    viewModel.setId(entity.getId());
    viewModel.setName(entity.getName());
    viewModel.setMainIngredient(entity.getIngredients().get(0).getFood().getName());
    viewModel.setEnergeticValue(entity.getNutrFact().getEnergeticValue());
    
		return viewModel;
	}
	
	public Recipe convertToRecipe(DietDayViewModel entity) {
	  Recipe recipe = new Recipe();
	  recipe.setId(entity.getId());
	  recipe.setName(entity.getName());
	  recipe.setServings(1);
	  return recipe;
	}
	
}
