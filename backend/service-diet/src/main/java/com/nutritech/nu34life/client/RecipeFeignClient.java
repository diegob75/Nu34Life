package com.nutritech.nu34life.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nutritech.nu34life.util.Recipe;

@FeignClient(name="service-recipes")
public interface RecipeFeignClient {
	@GetMapping("/recipes/{id}")
	public Recipe getRecipes(@PathVariable Long id);
}
