package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;


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

    
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
}
