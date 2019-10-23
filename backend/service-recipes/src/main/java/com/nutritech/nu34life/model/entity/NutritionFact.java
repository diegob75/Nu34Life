package com.nutritech.nu34life.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getEnergeticValue() {
		return energeticValue;
	}

	public void setEnergeticValue(Double energeticValue) {
		this.energeticValue = energeticValue;
	}

	public Double getTotalFat() {
		return totalFat;
	}

	public void setTotalFat(Double totalFat) {
		this.totalFat = totalFat;
	}

	public Double getSaturatedFats() {
		return saturatedFats;
	}

	public void setSaturatedFats(Double saturatedFats) {
		this.saturatedFats = saturatedFats;
	}

	public Double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(Double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public Double getSugars() {
		return sugars;
	}

	public void setSugars(Double sugars) {
		this.sugars = sugars;
	}

	public Double getProtein() {
		return protein;
	}

	public void setProtein(Double protein) {
		this.protein = protein;
	}

	public Double getSalt() {
		return salt;
	}

	public void setSalt(Double salt) {
		this.salt = salt;
	}
	
}
