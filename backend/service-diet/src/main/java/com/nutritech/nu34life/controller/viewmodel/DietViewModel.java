package com.nutritech.nu34life.controller.viewmodel;

import java.time.LocalDate;

public class DietViewModel{
    
    private Long id;

    private Long nutritionistId;

    private Long stateId;

    private LocalDate startDate;

    private Short duration;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Long getNutritionistId() {
      return nutritionistId;
    }

    public void setNutritionistId(Long nutritionistId) {
      this.nutritionistId = nutritionistId;
    }

    public Long getStateId() {
      return stateId;
    }

    public void setStateId(Long stateId) {
      this.stateId = stateId;
    }

    public LocalDate getStartDate() {
      return startDate;
    }

    public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
    }

    public Short getDuration() {
      return duration;
    }

    public void setDuration(Short duration) {
      this.duration = duration;
    }
    
    
}

