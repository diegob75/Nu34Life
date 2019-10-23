package com.nutritech.nu34life.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "diet_day_details")
public class DietDayDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "diet_day")
    public DietDay dietDay;

    @NotNull
    @Column
    public Long recipeId;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    public Meal meal;
}
