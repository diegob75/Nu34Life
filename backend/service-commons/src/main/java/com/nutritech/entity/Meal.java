package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;    
}
