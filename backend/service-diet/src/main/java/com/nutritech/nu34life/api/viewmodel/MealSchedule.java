package com.nutritech.nu34life.api.viewmodel;

import java.util.List;

import lombok.Data;

@Data
public class MealSchedule {
	Long id;
	String name;
	List<DietDayDetailViewModel> detail;
}
