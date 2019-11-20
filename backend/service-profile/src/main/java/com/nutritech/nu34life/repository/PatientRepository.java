package com.nutritech.nu34life.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query("from Patient p where p.nutritionistId = :id")
	List<Patient> getAffiliatedPatient(@Param("id") Long nutritionistId);
}
