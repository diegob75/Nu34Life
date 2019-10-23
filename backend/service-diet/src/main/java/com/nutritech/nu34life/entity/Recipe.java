package com.nutritech.nu34life.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Recipe {

    Long id;

    Integer servings;

    Long nutritionFactId;

    LocalDateTime createdOn;

    LocalDateTime lastModifiedOn;
}