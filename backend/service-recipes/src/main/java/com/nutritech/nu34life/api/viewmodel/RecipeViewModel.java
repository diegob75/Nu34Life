package com.nutritech.nu34life.api.viewmodel;

import java.util.List;

import com.nutritech.nu34life.model.entity.Step;

public class RecipeViewModel {
	
	private Long id;
	
	private String name;
	
	private Integer servings;
	
	private List<Step> steps;
	
	private List<IngredientViewModel> ingredient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getServings() {
		return servings;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public List<IngredientViewModel> getIngredient() {
		return ingredient;
	}

	public void setIngredient(List<IngredientViewModel> ingredient) {
		this.ingredient = ingredient;
	}
	
	
}
