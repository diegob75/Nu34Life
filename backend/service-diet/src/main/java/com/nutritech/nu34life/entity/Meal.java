package com.nutritech.nu34life.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
}
