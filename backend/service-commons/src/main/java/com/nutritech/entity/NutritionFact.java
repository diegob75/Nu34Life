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
	public Long id;

	@Column(name = "energetic_value")
	public Double energeticValue;
	
	@Column(name = "total_fat")
	public Double totalFat;
	
	@Column(name = "saturated_fats")
	public Double saturatedFats;
	
	@Column(name = "carbohydrates")
	public Double carbohydrates;
	
	@Column(name = "sugars")
	public Double sugars;
	
	@Column(name = "protein")
	public Double protein;
	
	@Column(name = "salt")
	public Double salt;	
}
