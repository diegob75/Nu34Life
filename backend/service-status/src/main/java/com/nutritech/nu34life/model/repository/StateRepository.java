package com.nutritech.nu34life.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nutritech.nu34life.model.entity.PatientState;

public interface StateRepository extends JpaRepository<PatientState, Long> {
	
	@Query("SELECT s "
			+ "FROM PatientState s "
			+ "WHERE s.patientId = :id "
			+ "ORDER BY s.lastModifiedDate DESC ")
	List<PatientState> findPatientHistory(Long id);
	
	List<PatientState> findAllByPatientIdOrderByLastModifiedDateDesc(Long patientId); 
}
