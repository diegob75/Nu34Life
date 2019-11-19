package com.nutritech.nu34life.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.nu34life.model.*;

@Repository
public interface DietRepository extends JpaRepository<Diet,Long>{
	Diet findByPatientId(Long patientId);
}
