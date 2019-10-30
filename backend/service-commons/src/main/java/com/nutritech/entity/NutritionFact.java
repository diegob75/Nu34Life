package com.nutritech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nutrition_facts")
public class NutritionFact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "energetic_value")
	private Double energeticValue;
	
	@Column(name = "total_fat")
	private Double totalFat;
	
	@Column(name = "saturated_fats")
	private Double saturatedFats;
	
	@Column(name = "carbohydrates")
	private Double carbohydrates;
	
	@Column(name = "sugars")
	private Double sugars;
	
	@Column(name = "protein")
	private Double protein;
	
	@Column(name = "salt")
	private Double salt;	
}
