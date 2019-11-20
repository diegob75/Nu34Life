package com.nutritech.nu34life.service;

import com.nutritech.nu34life.model.*;

public interface DietService extends CrudService<Diet,Long> {
	Diet findDietsbyPatient(Long id);
}
