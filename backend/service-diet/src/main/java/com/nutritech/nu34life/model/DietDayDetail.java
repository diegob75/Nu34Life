package com.nutritech.nu34life.model;

import lombok.Data;

import javax.persistence.*;

import com.nutritech.nu34life.util.Recipe;


@Data
@Entity
@Table(name = "diet_day_details")
public class DietDayDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "diet_day")
    private DietDay dietDay;

    
    @ManyToOne(targetEntity = Recipe.class)
    @JoinColumn(name = "recipe_id")
    private Long idRecipe;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
}
