package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.entity.Recipe;
import com.nutritech.nu34life.api.viewmodel.RecipeViewModel;

public interface RecipeService extends CrudService<Recipe, Long>{

	public List<Recipe> getByNameLike(String string);
}
