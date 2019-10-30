package com.nutritech.nu34life.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.entity.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long>{
	
}
