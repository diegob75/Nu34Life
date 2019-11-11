package com.nutritech.nu34life.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.entity.*;
import com.nutritech.nu34life.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping("/name/{string}")
	public List<Food> getFoodsByNameLike(@PathVariable String string) {
		return foodService.getByNameLike(string);
	}
	
	@GetMapping
	public List<Food> getFoods(){
		return foodService.getAll();
	}
	
	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable Long id) {
		return foodService.getOne(id).get();
	}
}
