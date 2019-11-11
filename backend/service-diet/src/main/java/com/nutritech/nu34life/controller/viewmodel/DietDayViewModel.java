package com.nutritech.nu34life.controller.viewmodel;

public class DietDayViewModel {
	
	private Long id;
	
	private String name;
	
	private String mainIngredient;
	
	private Double energeticValue;

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

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}

	public Double getEnergeticValue() {
		return energeticValue;
	}

	public void setEnergeticValue(Double energeticValue) {
		this.energeticValue = energeticValue;
	}
	
}
