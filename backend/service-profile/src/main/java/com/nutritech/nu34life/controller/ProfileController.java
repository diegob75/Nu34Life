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
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	NutritionistService nutritionistService;
	
	@Autowired
	PatientService patientService;
	
	@GetMapping(path="/nutritionist")
	public List<Nutritionist> getAllNutritionist(){
		return nutritionistService.getAll();
	}
	
	@GetMapping(path="/patient")
	public List<Patient> getAllPatient(){
		return patientService.getAll();
	}
	
	@GetMapping(path="/nutritionist/{id}")
	public Nutritionist getByIdNutritionist(@PathVariable Long id) {
		return nutritionistService.getById(id);
	}
	@GetMapping(path="/patient/{id}")
	public Patient getByIdPatient(@PathVariable Long id) {
		return patientService.getById(id);
	}
	
	@PostMapping(path="/nutritionist")
	public Nutritionist saveNutritionist(@RequestBody Nutritionist requestBody) {
		return nutritionistService.save(requestBody);
	}
	@PostMapping(path="/patient")
	public Patient savePatient(@RequestBody Patient requestBody) {
		return patientService.save(requestBody);
	}
	
	
}
