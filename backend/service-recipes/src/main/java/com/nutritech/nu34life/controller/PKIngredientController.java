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
import com.nutritech.nu34life.model.entity.PkIngredient;
import com.nutritech.nu34life.service.PKIngredientService;

@RestController
@RequestMapping("/ingredients")
public class PKIngredientController {

	@Autowired
	private Environment env;

	@Autowired
	private PKIngredientService pkIngredientService;
	
	@GetMapping
	public ResponseEntity<List<PkIngredient>> getPkIngredients() {
		List<PkIngredient> pkIngredients = pkIngredientService.getAll().stream().map(pkIngredient -> {
			return pkIngredient;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<PkIngredient>>(pkIngredients, HttpStatus.OK);
	}
	

	
	@PostMapping
	public ResponseEntity<PkIngredient> createPkIngredient(@RequestBody PkIngredient pkIngredient) {
		pkIngredientService.create(pkIngredient);
		return new ResponseEntity<PkIngredient>(pkIngredient, HttpStatus.CREATED);
	}

	

	
}
