package com.nutritech.nu34life.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutritech.entity.*;
import org.springframework.stereotype.Repository;
@Repository
public interface DietDayDetailRepository extends JpaRepository<DietDayDetail, Long> {

}
