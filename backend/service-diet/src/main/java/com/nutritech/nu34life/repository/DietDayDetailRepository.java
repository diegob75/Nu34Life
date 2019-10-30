package com.nutritech.nu34life.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutritech.entity.*;
@Repository
public interface DietDayDetailRepository extends JpaRepository<DietDayDetail, Long> {

}
