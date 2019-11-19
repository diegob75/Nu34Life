package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
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
		//TODO: obtener el userId del header??
		Long userId = 1L;
		
		List<Food> list =  foodService.getAll();
		
		if (userId != null) {
			List<Food> aux = foodService.getOwnRecipes(userId);
			list = Lists.newArrayList(Iterables.concat(aux, list));
		}
		
		return list;
	}
	
	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable Long id) {
		return foodService.getOne(id).get();
	}
	@PostMapping
	public Food createFood(@RequestBody Food requestBody) {
		return foodService.save(requestBody);
	}
	
	@PutMapping("/{id}")
	public Boolean deactivateFood(@PathVariable Long id) {
		//TODO: obtener el userId del header??
		Long userId = 1L;
		
		return foodService.deactivateFood(id, userId) > 0;
	}
}
