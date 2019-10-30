package com.nutritech.nu34life.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.entity.Food;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{
	//@Query("SELECT F FROM Food F WHERE LOWER(F.name) LIKE LOWER(concat('%', ?1, '%'))")
	List<Food> findByNameContainingIgnoreCase(String name);
}
