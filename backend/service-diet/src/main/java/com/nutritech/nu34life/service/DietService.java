package com.nutritech.nu34life.service;

import java.util.List;

import com.nutritech.nu34life.model.*;

public interface DietService extends CrudService<Diet,Long> {
	Diet findDietsbyPatient(Long id);
}
