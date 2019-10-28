package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.api.viewmodel.RecipeViewModel;
import com.nutritech.nu34life.model.entity.Recipe;

public interface RecipeService extends CrudService<Recipe, Long>{

	public List<RecipeViewModel> getByNameLike(String string);
}
