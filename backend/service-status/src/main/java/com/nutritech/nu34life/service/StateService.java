package com.nutritech.nu34life.service;

import java.util.List;
import java.util.Optional;

import com.nutritech.nu34life.model.entity.PatientState;

public interface StateService extends CrudService<PatientState, Long> {
	
	Optional<PatientState> findPatientLastState(Long id);
	List<PatientState> findPatientHistory(Long id);
	
}
