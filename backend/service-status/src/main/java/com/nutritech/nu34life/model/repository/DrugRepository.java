package com.nutritech.nu34life.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritech.nu34life.model.entity.Drug;

public interface DrugRepository extends JpaRepository<Drug,Long> {

}
