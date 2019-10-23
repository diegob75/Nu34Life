package com.nutritech.nu34life.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritech.nu34life.entity.DietDay;
import org.springframework.stereotype.Repository;
@Repository
public interface DietDayRepository extends JpaRepository<DietDay, Long>{

}
