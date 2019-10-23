package com.nutritech.nu34life.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.exception.ResourceNotFoundException;
import com.nutritech.nu34life.model.entity.Recipe;
import com.nutritech.nu34life.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private Environment env;

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	public ResponseEntity<List<Recipe>> getRecipes() {
		List<Recipe> recipes = recipeService.getAll().stream().map(recipe -> {
			recipe.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return recipe;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getFoodById(@PathVariable Long id) {
		 Optional<Recipe> recipe = recipeService.getOne(id);
		 recipe.get().setPort(Integer.parseInt(env.getProperty("local.server.port")));
	        if (!recipe.isPresent()) {
	           new ResourceNotFoundException("Id " + id + " is not existed");
	        }
	        return ResponseEntity.ok(recipe.get());
	}
}
