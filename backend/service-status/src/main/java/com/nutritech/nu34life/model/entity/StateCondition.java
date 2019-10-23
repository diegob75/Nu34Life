package com.nutritech.nu34life.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state_conditions")
public class StateCondition {
	
    @EmbeddedId
    StateConditionId id;

    @ManyToOne
    @MapsId("stateId")
    @JoinColumn(name = "state_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    PatientState state;

    @ManyToOne
    @MapsId("conditionId")
    @JoinColumn(name = "condition_id")
    MedicalCondition condition;
    
    @NotNull
    @Column
    String details;
}
