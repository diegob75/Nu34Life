package com.nutritech.nu34life.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {

	@EmbeddedId
	PkIngredient id;
	
	@ManyToOne
    @MapsId("recipe_id")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
	
	@ManyToOne
    @MapsId("food_id")
    @JoinColumn(name = "food_id")
    private Food food;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "unit", length = 2)
	private String unit;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nutr_fact_id")
	private NutritionFact nutrFact;

	public PkIngredient getId() {
		return id;
	}

	public void setId(PkIngredient id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

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
	
	
	
}