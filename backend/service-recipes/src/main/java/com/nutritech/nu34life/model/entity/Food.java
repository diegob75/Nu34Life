package com.nutritech.nu34life.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "foods")
public class Food {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "created_by")
	public Long createdBy;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name="image")
	private String image;
	
	@JsonIgnore
	@Column(name="active")
	private Boolean active = true;

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},optional=false)
	@JoinColumn(name = "nutr_fact_id")
	private NutritionFact nutrFact;
}
