package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nutritech.nu34life.model.*;
import com.nutritech.nu34life.service.DietService;
import com.nutritech.nu34life.service.MealService;


@RestController
@RequestMapping("/diets")
public class DietController {
	@Autowired
	private DietService dietService;
	
	@Autowired
	private MealService mealService;
	
	
	@GetMapping
	public List<Diet> getDiets(){
		return dietService.findAll();
	 }
	
	 @GetMapping(path="/{id}")
	  public Diet getDietById(@PathVariable Long id){
	    return dietService.findById(id).get();
	  }
   @PostMapping
   public ResponseEntity<Diet> createDiet(@RequestBody Diet diet){
        Diet result = dietService.save(diet);	
        return new ResponseEntity<Diet>(result, HttpStatus.CREATED);
   }
   @DeleteMapping(path="/{id}")
   public Diet deleteDietById(@PathVariable Long id){
     Diet diet = dietService.findById(id).get();   
     dietService.delete(id);
     return diet;   
   }
   
   @GetMapping(path="/meals")
   public List<Meal> getMeals(){
     return mealService.findAll();
   }
}
