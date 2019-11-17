package com.nutritech.nu34life.model;

import lombok.Data;

import javax.persistence.*;

import com.nutritech.nu34life.util.Nutritionist;
import com.nutritech.nu34life.util.Patient;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "diets")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity = Nutritionist.class)
	@JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionistId;
    
    @ManyToOne(targetEntity = Patient.class)
	@JoinColumn(name = "patient_id")
    private Patient patientId;
    
    @Column
    private LocalDate creationDate;
    
    @Column
    private LocalDate startDate;
 
    @Column
    private Short duration;

    @OneToMany(mappedBy="diet",fetch = FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private List<DietDay> dietDays;
}

