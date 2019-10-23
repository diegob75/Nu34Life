package com.nutritech.nu34life.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.model.entity.NutritionFact;

@Repository
public interface NutritionFactRepository extends JpaRepository<NutritionFact, Long>{
	
}
