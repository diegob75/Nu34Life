package com.nutritech.nu34life.service.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.*;
import com.nutritech.nu34life.model.repository.FoodRepository;
import com.nutritech.nu34life.model.repository.RecipeRepository;
import com.nutritech.nu34life.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private FoodRepository foodRepository;

	@Override
	public Recipe create(Recipe entity) {
		
		entity.getIngredients().forEach(x -> {
			x.setFood(foodRepository.findById(x.getFood().getId()).get());
			x.setRecipe(entity);
		});
		entity.getSteps().forEach(x -> x.setRecipe(entity));
		
		NutritionFact nutrFact = new NutritionFact();
		nutrFact.setCarbohydrates(Double.valueOf(0));
		nutrFact.setEnergeticValue(Double.valueOf(0));
		nutrFact.setProtein(Double.valueOf(0));
		nutrFact.setSalt(Double.valueOf(0));
		nutrFact.setSaturatedFats(Double.valueOf(0));
		nutrFact.setSugars(Double.valueOf(0));
		nutrFact.setTotalFat(Double.valueOf(0));
		
		for(Ingredient i : entity.getIngredients()) {
			nutrFact.setCarbohydrates(BigDecimal.valueOf(nutrFact.getCarbohydrates() + i.getFood().getNutrFact().getCarbohydrates() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setEnergeticValue(BigDecimal.valueOf(nutrFact.getEnergeticValue() + i.getFood().getNutrFact().getEnergeticValue() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setProtein(BigDecimal.valueOf(nutrFact.getProtein() + i.getFood().getNutrFact().getProtein() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setSalt(BigDecimal.valueOf(nutrFact.getSalt() + i.getFood().getNutrFact().getSalt() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setSaturatedFats(BigDecimal.valueOf(nutrFact.getSaturatedFats() + i.getFood().getNutrFact().getSaturatedFats() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setSugars(BigDecimal.valueOf(nutrFact.getSugars() + i.getFood().getNutrFact().getSugars() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setTotalFat(BigDecimal.valueOf(nutrFact.getTotalFat() + i.getFood().getNutrFact().getTotalFat() * i.getQuantity()/100).setScale(4).doubleValue());
		}
		entity.setNutrFact(nutrFact);
		return recipeRepository.save(entity);
	}

	@Override
	public List<Recipe> getAll() {
		List<Recipe> recipes = recipeRepository.findAll();
		for(Recipe r : recipes) {
			r.setIngredients(null);
			r.setSteps(null);
			r.setNutrFact(null);
		}
		return recipes;
	}

	@Override
	public Optional<Recipe> getOne(Long id) {
		return recipeRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		recipeRepository.deleteById(id);
	}
	
	@Override
	public List<Recipe> getByNameLike(String string){
		List<Recipe> recipes = recipeRepository.findByNameContainingIgnoreCase(string);
		for(Recipe r : recipes) {
			r.setIngredients(null);
			r.setSteps(null);
			r.setNutrFact(null);
		}
		return recipes;
	}

	@Override
	public Recipe update(Recipe entity) {
		entity.getIngredients().forEach(x -> {
			x.setFood(foodRepository.findById(x.getFood().getId()).get());
			x.setRecipe(entity);
		});
		entity.getSteps().forEach(x -> x.setRecipe(entity));
		
		NutritionFact nutrFact = new NutritionFact();
		nutrFact.setCarbohydrates(Double.valueOf(0));
		nutrFact.setEnergeticValue(Double.valueOf(0));
		nutrFact.setProtein(Double.valueOf(0));
		nutrFact.setSalt(Double.valueOf(0));
		nutrFact.setSaturatedFats(Double.valueOf(0));
		nutrFact.setSugars(Double.valueOf(0));
		nutrFact.setTotalFat(Double.valueOf(0));
		
		for(Ingredient i : entity.getIngredients()) {
			nutrFact.setCarbohydrates(BigDecimal.valueOf(nutrFact.getCarbohydrates() + i.getFood().getNutrFact().getCarbohydrates() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setEnergeticValue(BigDecimal.valueOf(nutrFact.getEnergeticValue() + i.getFood().getNutrFact().getEnergeticValue() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setProtein(BigDecimal.valueOf(nutrFact.getProtein() + i.getFood().getNutrFact().getProtein() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setSalt(BigDecimal.valueOf(nutrFact.getSalt() + i.getFood().getNutrFact().getSalt() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setSaturatedFats(BigDecimal.valueOf(nutrFact.getSaturatedFats() + i.getFood().getNutrFact().getSaturatedFats() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setSugars(BigDecimal.valueOf(nutrFact.getSugars() + i.getFood().getNutrFact().getSugars() *  i.getQuantity()/100).setScale(4).doubleValue());
			nutrFact.setTotalFat(BigDecimal.valueOf(nutrFact.getTotalFat() + i.getFood().getNutrFact().getTotalFat() * i.getQuantity()/100).setScale(4).doubleValue());
		}
		entity.setNutrFact(nutrFact);
		return recipeRepository.save(entity);
	}

}
