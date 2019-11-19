package com.nutritech.nu34life.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.entity.*;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{
	//@Query("SELECT F FROM Food F WHERE LOWER(F.name) LIKE LOWER(concat('%', ?1, '%'))")
	List<Food> findByNameContainingIgnoreCase(String name);
	
	@Query("from Food f where f.createdBy = 0 and f.active = TRUE")
	List<Food> getBaseRecipes();
	
	@Query("from Food f where f.createdBy = :id and f.active = TRUE")
	List<Food> getOwnRecipes(@Param("id") Long id);

	@Modifying
	@Query("update Food f set f.active = FALSE where f.id = :id and f.createdBy = :userId")
	Integer deactivateEntry(@Param("id") Long id, @Param("userId") Long userId);
	
	
}
