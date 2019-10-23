package com.nutritech.nu34life.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.exception.ResourceNotFoundException;
import com.nutritech.nu34life.model.entity.Food;
import com.nutritech.nu34life.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {

	@Autowired
	private Environment env;

	@Autowired
	private FoodService foodService;
	
	@GetMapping
	public ResponseEntity<List<Food>> getFoods() {
		List<Food> foods = foodService.getAll().stream().map(food -> {
			food.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return food;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
		 Optional<Food> food = foodService.getOne(id);
		 food.get().setPort(Integer.parseInt(env.getProperty("local.server.port")));
	        if (!food.isPresent()) {
	           new ResourceNotFoundException("Id " + id + " is not existed");
	        }
	        return ResponseEntity.ok(food.get());
	}
	
	@PostMapping
	public ResponseEntity<Food> createFood(@RequestBody Food food) {
		foodService.create(food);
		return new ResponseEntity<Food>(food, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id,  @RequestBody Food food) {
        if (!foodService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Food not found with id " + id);
        }
        return ResponseEntity.ok(foodService.create(food));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFood(@PathVariable("id") Long id) {
		return foodService.getOne(id).map(food -> {
			foodService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + id));
	}
	
}
