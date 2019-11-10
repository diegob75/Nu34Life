package com.nutritech.nu34life.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.entity.*;
import com.nutritech.nu34life.api.viewmodel.RecipeViewModel;
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
		Recipe r = new Recipe();
		
		Step step = new Step();
		step.setInstruction("asdga");
		step.setStepNumber(1);
		
		Ingredient i = new Ingredient();
		
		
		NutritionFact n = new NutritionFact();
		n.setCarbohydrates(Double.valueOf(3.2));
		n.setEnergeticValue(Double.valueOf(3.2));
		n.setProtein(Double.valueOf(3.2));
		n.setSalt(Double.valueOf(3.2));
		n.setSaturatedFats(Double.valueOf(3.2));
		n.setSugars(Double.valueOf(3.2));
		n.setTotalFat(Double.valueOf(3.2));
		
		i.setQuantity(1);
		i.setUnit("adag");
		i.setNutrFact(n);
		Food f = new Food();
		f.setId(Long.valueOf(1));
		f.setName("asdgf");
		f.setNutrFact(n);
		
		i.setFood(f);
		
		List<Ingredient>is = new ArrayList<>();
		List<Step>st = new ArrayList<>();
		is.add(i);
		
		st.add(step);
		
		r.setName("asd");
		r.setServings(5);
		r.setNutrFact(n);
		r.setIngredients(is);
		r.setSteps(st);
		
		return r;
		/*Recipe recipe = recipeService.getOne(id).get();
		return recipe;*/
	}
	
	@GetMapping("/name/{string}")
	public List<Recipe> getRecipesByNameLike(@PathVariable String string){
		return recipeService.getByNameLike(string);
	}
	
	@PostMapping
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return recipeService.create(recipe);
	}
}
