package com.nutritech.nu34life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nutritech.nu34life.model.entity.*;

public interface FoodService extends CrudService<Food, Long>{

	public List<Food> getByNameLike(String string);
	
	public Integer deactivateFood(Long id, Long userId);
	
	public Page<Food> searchFood(Long id, String query, Pageable pageable);
	
}
