package com.nutritech.nu34life.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nutritech.nu34life.entity.Diet;
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
	
    @PostMapping
    public ResponseEntity<Diet> createPatientState(@RequestBody Diet diet){
    	
    	Diet result = dietService.save(diet);
    	
        return new ResponseEntity<Diet>(result, HttpStatus.CREATED);
    }
	
	
}
