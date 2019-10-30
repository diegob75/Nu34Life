package com.nutritech.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AffiliationId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "nutritionist_id")
	Long nutritionistId;
	
	@Column(name = "patient_id")
	Long patientId;
}
