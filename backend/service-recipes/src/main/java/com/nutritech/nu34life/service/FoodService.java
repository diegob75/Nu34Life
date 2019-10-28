package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.model.entity.Food;

public interface FoodService extends CrudService<Food, Long>{

	public List<Food> getByNameLike(String string);
	
}
