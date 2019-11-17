package com.nutritech.nu34life.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "foods")
@EqualsAndHashCode(of = {"id"})
public class Food {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name="imagen")
	private String imagen;

	@OneToOne(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},optional=false)
	@JoinColumn(name = "nutr_fact_id")
	private NutritionFact nutrFact;
}
