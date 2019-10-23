package com.nutritech.nu34life.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "state_drugs")
public class StateDrug {
	
    @EmbeddedId
    StateDrugId id;

    @ManyToOne
    @MapsId("stateId")
    @JoinColumn(name = "state_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    PatientState state;

    @ManyToOne
    @MapsId("drugId")
    @JoinColumn(name = "drug_id")
    Drug drug;
    
    @Column
    String brandName;

    @NotNull
    @Column
    Integer dose;
    
    @NotNull
    @Column
    String unit;
    
    @NotNull
    @Column
    String frequency;
    
    @Column
    LocalDate starDate;
    
    @Column
    LocalDate stopDate;
    
    @NotNull
    @Column
    String details;
}
