package com.nutritech.nu34life;

import org.springframework.stereotype.Component;

import com.nutritech.nu34life.api.viewmodel.DietDayViewModel;
import com.nutritech.entity.Diet;
import com.nutritech.entity.Recipe;

@Component
public class Mapper {
	

	public DietDayViewModel convertDietViewModel(Diet entity) {
		
    /*DietViewModel viewModel = new DietDayViewModel();
    viewModel.setId(entity.getId());
    viewModel.setName(entity.getName());
    viewModel.setMainIngredient(entity.getIngredients().get(0).getFood().getName());
    viewModel.setEnergeticValue(entity.getNutrFact().getEnergeticValue());
    */
		return null;
	}
	
	public Recipe convertToRecipe(DietDayViewModel entity) {
	 /* Recipe recipe = new Recipe();
	  recipe.setId(entity.getId());
	  recipe.setName(entity.getName());
	  recipe.setServings(1);
	  return recipe;*/
	  return null;
	}
	
}
