package com.nutritech.nu34life.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nutritech.nu34life.audit.Auditable;
import com.nutritech.nu34life.audit.PatientStateListener;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient_status")
@EqualsAndHashCode (callSuper = false)
@EntityListeners(value = {AuditingEntityListener.class, PatientStateListener.class})
public class PatientState extends Auditable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
	@Version
	Long version;
	    
    @Transient
    User patient;
    
    @NotNull
    @Column(name = "patient_id")
    Long patientId;

    @NotNull
    @Column
    Double height;

    @NotNull
    @Column
    Double weight;

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "state_goals",
            joinColumns = @JoinColumn(name = "goal_id"),
            inverseJoinColumns = @JoinColumn(name = "state_id"))
    List<Goal> goals;
    
    @OneToMany(mappedBy = "state", orphanRemoval = true, cascade = CascadeType.ALL)
    List<Allergy> allergies;

    @OneToMany(mappedBy = "state", orphanRemoval = true, cascade = CascadeType.ALL)
    List<StateCondition> conditions;

    @OneToMany(mappedBy = "state", orphanRemoval = true, cascade = CascadeType.ALL)
    List<StateDrug> drugs;

    @OneToMany(mappedBy = "state", orphanRemoval = true, cascade = CascadeType.ALL)
    List<StateActivity> activities;

    @NotNull
    String additionalInfo;
    
}
