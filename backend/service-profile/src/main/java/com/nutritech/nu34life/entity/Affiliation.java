package com.nutritech.nu34life.entity;


import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "affiliations")
public class Affiliation {
	@EmbeddedId
	AffiliationId id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    @MapsId("nutritionistId")
    @JoinColumn(name = "nutritionist_id")
    Nutritionist nutritionist;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    @MapsId("pataientId")
    @JoinColumn(name = "patient_id")
    Patient patient;

    @Column
    Boolean confirmed;

    @Column
    LocalDateTime creationDate;

    @Column
    LocalDate affiliationDate;

    @Column
    LocalDateTime terminationDate; 
}
