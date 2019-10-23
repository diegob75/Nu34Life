package com.nutritech.nu34life.api;

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
import com.nutritech.nu34life.model.entity.Step;
import com.nutritech.nu34life.service.StepService;

@RestController
@RequestMapping("/steps")
public class StepController {

	@Autowired
	private Environment env;

	@Autowired
	private StepService stepService;
	
	@GetMapping
	public ResponseEntity<List<Step>> getSteps() {
		List<Step> steps = stepService.getAll().stream().map(step -> {
			return step;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Step>>(steps, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Step> getStepById(@PathVariable Long id) {
		 Optional<Step> step = stepService.getOne(id);
	        if (!step.isPresent()) {
	           new ResourceNotFoundException("Id " + id + " is not existed");
	        }
	        return ResponseEntity.ok(step.get());
	}
	
	@PostMapping
	public ResponseEntity<Step> createStep(@RequestBody Step step) {
		stepService.create(step);
		return new ResponseEntity<Step>(step, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Step> updateStep(@PathVariable Long id,  @RequestBody Step step) {
        if (!stepService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Step not found with id " + id);
        }
        return ResponseEntity.ok(stepService.create(step));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStep(@PathVariable("id") Long id) {
		return stepService.getOne(id).map(step -> {
			stepService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Step not found with id " + id));
	}
	
}

