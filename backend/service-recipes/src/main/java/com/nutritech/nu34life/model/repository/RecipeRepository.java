package com.nutritech.nu34life.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.entity.*;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	//@Query("SELECT R FROM Recipe R WHERE LOWER(R.name) LIKE LOWER(concat('%', ?1, '%'))")
	List<Recipe> findByNameContainingIgnoreCase(String name);
}
