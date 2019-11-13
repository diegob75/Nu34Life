package com.nutritech.nu34life.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {

	@EmbeddedId
	private IngredientId id = new IngredientId();
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	@ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
	private Food food;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "unit", length = 2)
	private String unit;
}