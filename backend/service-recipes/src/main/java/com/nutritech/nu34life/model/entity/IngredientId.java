package com.nutritech.nu34life.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class IngredientId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "recipe_id")
	private Long recipeId;
	
	@Column(name = "food_id")
	private Long foodId;
}
