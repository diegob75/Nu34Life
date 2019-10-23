package com.nutritech.nu34life.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "steps")
public class Step {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "instruction", length = 255)
	private String instruction;
	
	@Column(name = "step_number")
	private Integer stepNumber;
	
	@ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

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

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
