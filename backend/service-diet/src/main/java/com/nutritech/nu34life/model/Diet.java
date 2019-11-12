package com.nutritech.nu34life.model;

import lombok.Data;

import javax.persistence.*;

import com.nutritech.nu34life.util.PatientState;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "diets")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Long nutritionistId;

    @ManyToOne(targetEntity = PatientState.class)
    @JoinColumn(name = "patient_state_id")
    private Long idPatientState;

    
    @Column
    private LocalDate creationDate;

    
    @Column
    private LocalDate startDate;

    
    @Column
    private Short duration;

    @OneToMany(mappedBy="diet",fetch = FetchType.EAGER)
    private List<DietDay> dietDays;
}

