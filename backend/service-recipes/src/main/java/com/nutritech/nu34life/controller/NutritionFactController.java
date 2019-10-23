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
import com.nutritech.nu34life.model.entity.NutritionFact;
import com.nutritech.nu34life.service.NutritionFactService;

@RestController
@RequestMapping("/nutritionfacts")
public class NutritionFactController {

	@Autowired
	private Environment env;

	@Autowired
	private NutritionFactService nutrifactService;
	
	@GetMapping
	public ResponseEntity<List<NutritionFact>> getNutritionFacts() {
		List<NutritionFact> nutritionFacts = nutrifactService.getAll().stream().map(nutritionFact -> {
			return nutritionFact;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<NutritionFact>>(nutritionFacts, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NutritionFact> getNutritionFactById(@PathVariable Long id) {
		 Optional<NutritionFact> nutritionFact = nutrifactService.getOne(id);
	        if (!nutritionFact.isPresent()) {
	           new ResourceNotFoundException("Id " + id + " is not existed");
	        }
	        return ResponseEntity.ok(nutritionFact.get());
	}
	
	@PostMapping
	public ResponseEntity<NutritionFact> createNutritionFact(@RequestBody NutritionFact nutritionFact) {
		nutrifactService.create(nutritionFact);
		return new ResponseEntity<NutritionFact>(nutritionFact, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<NutritionFact> updateNutritionFact(@PathVariable Long id,  @RequestBody NutritionFact nutritionFact) {
        if (!nutrifactService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("nutritionFact not found with id " + id);
        }
        return ResponseEntity.ok(nutrifactService.create(nutritionFact));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNutritionFact(@PathVariable("id") Long id) {
		return nutrifactService.getOne(id).map(nutritionFact -> {
			nutrifactService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("nutritionFact not found with id " + id));
	}
	
}
