package com.nutritech.nu34life.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "recipes")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "created_by")
	public Long createdBy;
	
	@Column(name = "name", nullable = false, length = 50)
	public String name;
	
	@Column(name = "servings")
	public Integer servings;
	
	@Column(name = "imagen")
	public String imagen;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "recipe_id")
	public List<Step> steps;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	@JoinColumn(name = "recipe_id", insertable = false, updatable = false)
	public List<Ingredient> ingredients;
	

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name = "nutr_fact_id")
	public NutritionFact nutrFact;
}
