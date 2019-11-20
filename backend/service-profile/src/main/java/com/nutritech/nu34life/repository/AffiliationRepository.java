package com.nutritech.nu34life.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nutritech.nu34life.entity.Affiliation;

public interface AffiliationRepository extends JpaRepository<Affiliation, Long> {
	
	@Query("from Affiliation a where a.active = true and a.patientId = :pId and a.nutritionistId = :nId")
	Optional<Affiliation> findLastActiveRequest(@Param("pId") Long patientId, @Param("nId") Long nutritionistId);
	
	@Modifying
	@Query("update Affiliation a set a.confirmed = true where a.id = :id and a.active = true and a.patientId = :pId")
	Integer confirmAffiliation(@Param("id") Long id, @Param("pId") Long patientId); 
}
