package com.nutritech.nu34life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nutritech.nu34life.model.entity.Recipe;

public interface RecipeService extends CrudService<Recipe, Long>{

	public List<Recipe> getByNameLike(String string);
	
	public Recipe update(Recipe entity);

	public Integer deactivateRecipe(Long id, Long userId);

	public Page<Recipe> searchRecipe(Long userId, String query, Pageable pageable);
}
