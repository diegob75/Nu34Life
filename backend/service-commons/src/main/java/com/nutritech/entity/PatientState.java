package com.nutritech.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient_status")
public class PatientState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
	@Version
	private Long version;
	    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    
    @Column
    private Double height;

    
    @Column
    private Double weight;
   
    
    private String additionalInfo;

}
