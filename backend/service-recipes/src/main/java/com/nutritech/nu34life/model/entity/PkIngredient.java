package com.nutritech.nu34life.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PkIngredient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Integer recipe_id;
	Integer food_id;
	
	public Integer getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(Integer recipe_id) {
		this.recipe_id = recipe_id;
	}
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}
	
}
