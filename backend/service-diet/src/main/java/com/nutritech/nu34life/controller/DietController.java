package com.nutritech.nu34life.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nutritech.entity.*;
import com.nutritech.nu34life.service.DietService;


@RestController
@RequestMapping("/diets")
public class DietController {
	@Autowired
	private DietService dietService;
	
	
	@GetMapping
	public List<Diet> getDiets(){
		/*List<Diet> diets = dietService.findAll()
			      .stream()
			      .collect(Collectors.toList());
	return new ResponseEntity<List<Diet>>(diets, HttpStatus.OK);*/
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
	
}
