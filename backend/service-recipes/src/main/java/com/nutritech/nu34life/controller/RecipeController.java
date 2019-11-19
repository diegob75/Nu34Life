package com.nutritech.nu34life.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nutritech.nu34life.model.entity.*;
import com.nutritech.nu34life.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	public List<Recipe> getRecipes() {
		List<Recipe> recipes = recipeService.getAll();

		return recipes;
	}
	
	@GetMapping("/{id}")
	public Recipe getRecipeById(@PathVariable Long id) {
		Recipe recipe = recipeService.getOne(id).get();
		return recipe;
	}
	
	@GetMapping("/name/{string}")
	public List<Recipe> getRecipesByNameLike(@PathVariable String string){
		return recipeService.getByNameLike(string);
	}
	
	@PostMapping
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return recipeService.save(recipe);
	}
}
