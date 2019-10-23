package com.nutritech.nu34life.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "allergies")
public class Allergy {
	
	@EmbeddedId
	AllergyId id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stateId")
    @JoinColumn(name = "state_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    PatientState state;

    @Transient
    Food food;

    @NotNull
    @Column(length = 255)
    String details;
}
