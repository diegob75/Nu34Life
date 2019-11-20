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
    
    public Affiliation() {}

	public Affiliation(Long id, Long nutritionistId, Long patientId, Nutritionist nutritionist, Patient patient,
			Boolean confirmed, Boolean active, LocalDateTime creationDate, LocalDate affiliationDate,
			LocalDateTime terminationDate) {
		super();
		this.id = id;
		this.nutritionistId = nutritionistId;
		this.patientId = patientId;
		this.nutritionist = nutritionist;
		this.patient = patient;
		this.confirmed = confirmed;
		this.active = active;
		this.creationDate = creationDate;
		this.affiliationDate = affiliationDate;
		this.terminationDate = terminationDate;
	}
}
