package com.nutritech.nu34life.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nutritech.nu34life.entity.Patient;

public interface PatientService extends CrudService<Patient, Long>{
	Page<Patient> getAll(Pageable pageable);
	
	Boolean requestAffiliation(Long patientId, Long nutritionistId);
	
	Boolean deaffiliate(Long patientId, Long nutritionistId);
	
	Boolean confirmAffiliation(Long id, Long patientId);
	
	List<Patient> findPatientAffiliated(Long id);
}
