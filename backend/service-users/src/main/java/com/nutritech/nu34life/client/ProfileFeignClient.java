package com.nutritech.nu34life.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nutritech.nu34life.util.Nutritionist;
import com.nutritech.nu34life.util.Patient;

@FeignClient(name="service-profiles")
public interface ProfileFeignClient {
	@PostMapping(path="/nutritionist")
	public Nutritionist saveNutritionist(@RequestBody Nutritionist requestBody);
	@PostMapping(path="/patients")
	public Patient savePatient(@RequestBody Patient requestBody);
	
	@GetMapping(path="/nutritionist/byUserId/{id}")
	public Nutritionist getByUserId(@PathVariable Long id);
	
	@PostMapping("/patients/affiliate/request/")
	public Boolean requestAffiliation(@RequestParam Long patientId, @RequestParam Long nutritionistId);
	
	@PostMapping("/patients/affiliate/confirm/")
	public Boolean confirmAffiliation(@RequestParam Long id,@RequestParam Long patientId);
}
