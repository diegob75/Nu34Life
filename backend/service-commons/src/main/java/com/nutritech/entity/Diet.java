package com.nutritech.entity;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "patient_state_id")
    private PatientState patientState;

    
    @Column
    private LocalDate creationDate;

    
    @Column
    private LocalDate startDate;

    
    @Column
    private Short duration;

    @OneToMany(mappedBy="diet",fetch = FetchType.EAGER)
    private List<DietDay> dietDays;
}

