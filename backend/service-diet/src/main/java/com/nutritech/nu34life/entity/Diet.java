package com.nutritech.nu34life.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "diets")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @Column
    public Long nutritionistId;

    @NotNull
    @Column
    public Long patientStateId;

    @NotNull
    @Column
    public LocalDate creationDate;

    @NotNull
    @Column
    public LocalDate startDate;

    @NotNull
    @Column
    public Short duration;

    @OneToMany(mappedBy="diet",fetch = FetchType.EAGER)
    public List<DietDay> dietDays;
}

