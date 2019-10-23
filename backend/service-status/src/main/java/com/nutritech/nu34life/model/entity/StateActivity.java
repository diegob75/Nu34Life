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
@Table(name = "state_activities")
public class StateActivity {
	
	@EmbeddedId
	StateActivityId id;
	
    @ManyToOne
    @MapsId("stateId")
    @JoinColumn(name = "state_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    PatientState state;

    @ManyToOne
    @MapsId("activityId")
    @JoinColumn(name = "activity_id")
    PhysicalActivity activity;
    
    @NotNull
    @Column
    Integer intensity;
    
    @NotNull
    @Column
    Integer daysPerWeek;
    
    @NotNull
    @Column
    Integer durationMinutes;
    
    @NotNull
    @Column
    String details;
}
