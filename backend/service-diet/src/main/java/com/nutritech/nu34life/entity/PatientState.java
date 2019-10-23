package com.nutritech.nu34life.entity;

import lombok.Data;

@Data
public class PatientState {

    Long id;

    Long patientId;

    Double height;

    Double weight;

    String additionalInfo;
}