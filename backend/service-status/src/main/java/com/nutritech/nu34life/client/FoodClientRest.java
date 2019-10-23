package com.nutritech.nu34life.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nutritech.nu34life.model.entity.Food;

@Component
public class FoodClientRest {
	
	Food[] foods = {
			new Food(Long.valueOf(1), "mani"),
			new Food(Long.valueOf(2), "leche"),
			new Food(Long.valueOf(3), "arroz"),
			new Food(Long.valueOf(4), "carne"),			
	};
	
	public List<Food> listFoods(){
		return Arrays.asList(foods);
	}
	
	public Food findFoodById(Long id) {
		return Arrays.asList(foods).stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
	}

}
