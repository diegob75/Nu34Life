package com.nutritech.nu34life.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
