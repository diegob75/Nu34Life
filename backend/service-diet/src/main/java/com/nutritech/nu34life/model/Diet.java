package com.nutritech.nu34life.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nutritech.nu34life.util.Nutritionist;
import com.nutritech.nu34life.util.Patient;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "diets")
public class Diet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "nutritionist_id", insertable = false, updatable = false)
	private Nutritionist nutritionist;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "patient_id", insertable = false, updatable = false)
	private Patient patient;
	
	@Column(name = "nutritionist_id")
	private Long nutritionistId;
	
	@Column(name = "patient_id")
	private Long patientId;

	@Column
	private LocalDate creationDate;

	@Column
	@JsonFormat(pattern =  "yyyy-MM-dd", timezone = "UTC")
	private LocalDate startDate;

	@Column
	private Short duration;

	@OneToMany(mappedBy = "diet", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.MERGE })
	private List<DietDay> dietDays;
}
