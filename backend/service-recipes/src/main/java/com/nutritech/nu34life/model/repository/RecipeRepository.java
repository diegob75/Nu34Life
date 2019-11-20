package com.nutritech.nu34life.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.model.entity.*;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	//@Query("SELECT R FROM Recipe R WHERE LOWER(R.name) LIKE LOWER(concat('%', ?1, '%'))")
	List<Recipe> findByNameContainingIgnoreCase(String name);
	
	@Query("from Recipe r where lower(r.name) like %:search% and r.active = true and (r.createdBy = 0 or r.createdBy = :id)")
	Page<Recipe> findRecipe(@Param("id") Long id, @Param("search") String search, Pageable pageable);

	@Modifying
	@Query("update Recipe r set r.active = FALSE where r.id = :id and r.createdBy = :userId")
	Integer deactivateEntry(@Param("id") Long id, @Param("userId") Long userId);
	
}
