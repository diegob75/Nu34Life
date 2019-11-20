package com.nutritech.nu34life.service;

import com.nutritech.nu34life.entity.Nutritionist;

public interface NutritionistService extends CrudService<Nutritionist,Long>{
	Nutritionist findByUserId(Long id);
}
