package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.entity.Nutritionist;
import com.nutritech.nu34life.entity.Patient;
import com.nutritech.nu34life.service.NutritionistService;
import com.nutritech.nu34life.service.PatientService;

@RestController
@RequestMapping("/nutritionist")
public class NutritionistController {
	@Autowired
	NutritionistService nutritionistService;

	
	@GetMapping
	public List<Nutritionist> getAllNutritionist(){
		return nutritionistService.getAll();
	}

	
	@GetMapping(path="/{id}")
	public Nutritionist getByIdNutritionist(@PathVariable Long id) {
		return nutritionistService.getById(id);
	}

	
	@PostMapping
	public Nutritionist saveNutritionist(@RequestBody Nutritionist requestBody) {
		return nutritionistService.save(requestBody);
	}
	@GetMapping(path="/byUserId/{id}")
	public Nutritionist getByUserId(@PathVariable Long id) {
		return nutritionistService.findByUserId(id);
	}

	
	
}
