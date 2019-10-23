package com.nutritech.nu34life.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "drug_categories")
public class DrugCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	@Column(unique = true)
	String name;
}
