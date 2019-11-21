package com.nutritech.nu34life.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.entity.Affiliation;
import com.nutritech.nu34life.entity.Patient;
import com.nutritech.nu34life.repository.AffiliationRepository;
import com.nutritech.nu34life.repository.PatientRepository;
import com.nutritech.nu34life.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AffiliationRepository affiliationRepository;
	
	@Override
	public Patient getById(Long id) {
		Patient patient = patientRepository.findById(id).get();
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		List<Patient> patients = patientRepository.findAll();
		return patients;
	}
	
	@Override
	public Page<Patient> getAll(Pageable pageable) {
		Page<Patient> patients = patientRepository.findAll(pageable);
		return patients;
	}

	@Override
	public Patient save(Patient entity) {
		return patientRepository.save(entity);
	}

	@Override
	public Boolean requestAffiliation(Long patientId, Long nutritionistId) {
		
		Affiliation last = affiliationRepository.findLastActiveRequest(patientId, nutritionistId).orElse(null);
		if (last != null)
			return false; //existe una solicitud o afiliacion activa
		
		Affiliation entity = Affiliation.builder()
				.active(true).confirmed(false)
				.patientId(patientId).nutritionistId(nutritionistId)
				.affiliationDate(null).terminationDate(null)
				.creationDate(LocalDateTime.now()).build();
		
		return affiliationRepository.save(entity) != null;
	}

	@Transactional
	@Override
	public Boolean deaffiliate(Long patientId, Long nutritionistId) {
		
		Affiliation last = affiliationRepository.findLastActiveRequest(patientId, nutritionistId).orElse(null);
		
		if (last == null || !last.getConfirmed())
			return false; // No se encuentra asociado
		
		last.setActive(false);
		last.setTerminationDate(LocalDateTime.now());
		
		Patient patient = last.getPatient();
		patient.setNutritionistId(null);
		
		patientRepository.save(patient);
		affiliationRepository.save(last);
		
		return true;
	}

	@Transactional
	@Override
	public Boolean confirmAffiliation(Long id, Long patientId) {

		Affiliation aff = affiliationRepository.findById(id).orElse(null);
		
		if (aff == null || aff.getPatientId() != patientId || aff.getConfirmed() || !aff.getActive())
			return false;
		
		Patient p = aff.getPatient();
		p.setNutritionistId(aff.getNutritionistId());
		aff.setConfirmed(true);
		
		affiliationRepository.save(aff);
		patientRepository.save(p);
		return true;
	}
	
	@Override
	public List<Patient> findPatientAffiliated(Long id){
		return patientRepository.getAffiliatedPatient(id);
	}

}
