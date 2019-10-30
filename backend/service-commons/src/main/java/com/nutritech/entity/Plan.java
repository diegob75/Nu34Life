package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private LocalDate validFrom;

    private LocalDate validTo;
}
