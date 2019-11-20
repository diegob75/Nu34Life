package com.nutritech.nu34life.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "affiliations")
public class Affiliation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "nutritionist_id", nullable = false)
	Long nutritionistId;
	
	@Column(name = "patient_id", nullable = false)
	Long patientId;
	
    @ManyToOne
    @JoinColumn(name = "nutritionist_id", insertable = false, updatable = false)
    Nutritionist nutritionist;

    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    Patient patient;

    @Column
    Boolean confirmed;
    
    @Column
    Boolean active;

    @Column
    LocalDateTime creationDate;

    @Column
    LocalDate affiliationDate;

    @Column
    LocalDateTime terminationDate; 
}
