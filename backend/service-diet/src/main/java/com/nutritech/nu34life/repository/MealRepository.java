package com.nutritech.nu34life.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritech.nu34life.entity.Meal;
import org.springframework.stereotype.Repository;
@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
