package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.entity.*;

public interface RecipeService extends CrudService<Recipe, Long>{

	public List<Recipe> getByNameLike(String string);
	
	public Recipe update(Recipe entity);
}
