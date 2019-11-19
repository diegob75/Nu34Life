package com.nutritech.nu34life.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
@Table(name = "steps")
public class Step {
	
	@EmbeddedId
	private StepId id;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@MapsId("recipeId")
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	@Column(name = "instruction", length = 255)
	private String instruction;
}
