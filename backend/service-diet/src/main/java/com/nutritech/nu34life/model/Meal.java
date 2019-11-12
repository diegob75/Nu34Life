package com.nutritech.nu34life.model;

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
