package com.nutritech.nu34life.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StepId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long recipeId;
	
	private Integer stepNumber; 

}
