package com.nutritech.nu34life.controller.viewmodel;

public class StepViewModel {

	private Long id;
	private String instruction;
	private Integer stepNumber;
	private Long recipeId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public Integer getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}
	public Long getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	
	
}
