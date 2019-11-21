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
public interface FoodRepository extends JpaRepository<Food, Long>{
	//@Query("SELECT F FROM Food F WHERE LOWER(F.name) LIKE LOWER(concat('%', ?1, '%'))")
	List<Food> findByNameContainingIgnoreCase(String name);
	
	@Query("from Food f where lower(f.name) like %:search% and f.active = true and (f.createdBy = 0 or f.createdBy = :id)")
	Page<Food> findFood(@Param("id") Long id, @Param("search") String search, Pageable pageable);

	@Modifying
	@Query("update Food f set f.active = FALSE where f.id = :id and f.createdBy = :userId and f.createdBy != 0")
	Integer deactivateEntry(@Param("id") Long id, @Param("userId") Long userId);
	
	
}
