package com.nutritech.nu34life.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.Patient;
import com.nutritech.nu34life.repository.PatientRepository;
import com.nutritech.nu34life.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	@Override
	public Patient getById(Long id) {
		Patient patient = patientRepository.findById(id).get();
		if(patient != null && patient.getNutritionist() != null) {
			patient.getNutritionist().setPatients(null);
		}
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		List<Patient> patients = patientRepository.findAll();
		for(Patient i : patients) {
			if(i.getNutritionist() != null) {
				i.getNutritionist().setPatients(null);
			}			
		}
		return patients;
	}

	@Override
	public Patient save(Patient entity) {
		return patientRepository.save(entity);
	}

}
