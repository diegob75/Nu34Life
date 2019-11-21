package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nutritech.nu34life.entity.Patient;
import com.nutritech.nu34life.service.PatientService;

@RestController
@RequestMapping(path = "/patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	
	@GetMapping
	public Page<Patient> getPatients(
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "order", defaultValue = "asc") String order,
			@RequestParam(name = "sort", required = false) String column,
			@RequestParam(name = "page_size", defaultValue = "20") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page){
		
		Sort sort = Sort.unsorted();

		if (column != null) {
			sort = Sort.by(column).ascending();
			if (order.equalsIgnoreCase("desc"))
				sort = sort.descending();
		}
		
		Pageable pageable = PageRequest.of(page, size, sort);
		
		return patientService.getAll(pageable);
	}
	
	@GetMapping(path="/{id}")
	public Patient getByIdPatient(@PathVariable Long id) {
		return patientService.getById(id);
	}
	
	@GetMapping(path="/byNutritionist/{id}")
	public List<Patient> findByNutritionist(@PathVariable Long id){
		return patientService.findPatientAffiliated(id);
	}
	
	@PostMapping
	public Patient savePatient(@RequestBody Patient requestBody) {
		return patientService.save(requestBody);
	}
	
	@PutMapping
	public Patient updatePatient(@RequestBody Patient requestBody) {
		return patientService.save(requestBody);
	}
	
	@PostMapping("/affiliate/request/")
	public Boolean requestAffiliation(@RequestParam Long patientId, @RequestParam Long nutritionistId) {
				
		return patientService.requestAffiliation(patientId, nutritionistId);
	}
	
	@GetMapping("/affiliate/confirm/")
	public Boolean confirmAffiliation(@RequestParam Long id,@RequestParam Long patientId) {
		
		return patientService.confirmAffiliation(id, patientId);
	}
	
	@PostMapping("/affiliate/deactivate/")
	public Boolean deafffiliate(@RequestParam Long patientId,@RequestParam Long nutritionistId) {
		
		return patientService.deaffiliate(patientId, nutritionistId);
	}
	
}
