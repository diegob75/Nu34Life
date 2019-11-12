package com.nutritech.nu34life.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {

	@EmbeddedId
	private IngredientId id;
	
/*	@ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
	private Recipe recipe;*/
	
	@ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
	private Food food;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "unit", length = 2)
	private String unit;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nutr_fact_id")
	private NutritionFact nutrFact;
}