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
import com.nutritech.nu34life.model.entity.*;
import com.nutritech.nu34life.service.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private Environment env;

	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping
	public ResponseEntity<List<Ingredient>> getIngredients() {
		List<Ingredient> ingredients = ingredientService.getAll().stream().map(ingredient -> {
			return ingredient;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Ingredient>>(ingredients, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> getIngredientbyId(@PathVariable Long id) {
		 Optional<Ingredient> ingredient = ingredientService.getOne(id);
	        if (!ingredient.isPresent()) {
	           new ResourceNotFoundException("Id " + id + " is not existed");
	        }
	        return ResponseEntity.ok(ingredient.get());
	}
	
	@PostMapping
	public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.create(ingredient);
		return new ResponseEntity<Ingredient>(ingredient, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id,  @RequestBody Ingredient ingredient) {
        if (!ingredientService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Ingredient not found with id " + id);
        }
        return ResponseEntity.ok(ingredientService.create(ingredient));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteIngredient(@PathVariable("id") Long id) {
		return ingredientService.getOne(id).map(ingredient -> {
			ingredientService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id " + id));
	}
	
}
