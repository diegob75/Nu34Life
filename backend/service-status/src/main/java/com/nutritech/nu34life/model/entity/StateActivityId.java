package com.nutritech.nu34life.model.entity;

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
public class StateActivityId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "state_id")
	Long stateId;
	
	@Column(name = "activity_id")
	Long activityId;

}
