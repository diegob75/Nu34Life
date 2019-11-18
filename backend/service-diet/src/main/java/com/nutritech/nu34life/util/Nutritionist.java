package com.nutritech.nu34life.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "nutritionists")
public class Nutritionist {
	
	@Id
	@GeneratedValue
	private Long id;

}
