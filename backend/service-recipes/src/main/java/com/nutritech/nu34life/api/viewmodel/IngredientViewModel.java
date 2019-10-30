package com.nutritech.nu34life.api.viewmodel;

import com.nutritech.entity.Food;
import com.nutritech.entity.NutritionFact;

public class IngredientViewModel {
	private Food food;
	private Long recipeId;
	private Integer quantity;
	private String unit;
	private NutritionFact nutrFact;
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public NutritionFact getNutrFact() {
		return nutrFact;
	}
	public void setNutrFact(NutritionFact nutrFact) {
		this.nutrFact = nutrFact;
	}
	public Long getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	
}
