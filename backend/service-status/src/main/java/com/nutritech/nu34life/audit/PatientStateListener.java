package com.nutritech.nu34life.audit;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.nutritech.nu34life.model.entity.PatientState;

//TODO: save history
public class PatientStateListener {
	
    @PrePersist
    public void prePersist(PatientState target) {
    	
    }

    @PreUpdate
    public void preUpdate(PatientState target) {
    	
    }

    @PreRemove
    public void preRemove(PatientState target) {
    	
    }
}
