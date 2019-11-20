package com.nutritech.nu34life.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.entity.Nutritionist;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Long>{
	Nutritionist findByUserId(Long id);
}
