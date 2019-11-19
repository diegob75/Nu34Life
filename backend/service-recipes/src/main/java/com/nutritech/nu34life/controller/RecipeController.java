package com.nutritech.nu34life.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/pageable")
	public Page<Recipe> getFoods(@RequestParam(value = "q", defaultValue = "") String query,
			@RequestParam(value = "sort", required = false) String column,
			@RequestParam(value = "order", defaultValue = "desc") String order,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "per_page", defaultValue = "20") Integer size,
			@RequestParam(value = "userId", defaultValue = "0") Long userId) {
		// TODO: obtener el userId del header??

		Sort sort = Sort.unsorted();

		if (column != null) {
			sort = Sort.by(column).descending();
			if (order == "asc")
				sort = sort.ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sort);
		
		Page<Recipe> result = recipeService.searchRecipe(userId, query, pageable);
		
		return result;
	}
	
	@PutMapping("/{id}")
	public Boolean deactivateRecipe(@PathVariable Long id) {
		// TODO: obtener el userId del header??
		Long userId = 1L;

		return recipeService.deactivateRecipe(id, userId) > 0;
	}
}
