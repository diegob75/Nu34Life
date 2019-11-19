package com.nutritech.nu34life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.nutritech.nu34life.model.entity.*;
import com.nutritech.nu34life.service.FoodService;

@RestController
@RequestMapping("/foods")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@GetMapping("/name/{string}")
	public List<Food> getFoodsByNameLike(@PathVariable String string) {
		return foodService.getByNameLike(string);
	}
	@GetMapping
	public List<Food> getAllFoods(){
		return foodService.getAll();
	}

	@GetMapping("/pageable")
	public Page<Food> getFoods(@RequestParam(value = "q", defaultValue = "") String query,
			@RequestParam(value = "sort", required = false) String column,
			@RequestParam(value = "order", defaultValue = "desc") String order,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "per_page", defaultValue = "20") Integer size,
			@RequestParam(value = "userId", defaultValue = "0") Long userId) {
		// TODO: obtener el userId del header??

		Sort sort = Sort.unsorted();

		if (column != null) {
			sort = Sort.by(column).descending();
			if (order == "asc")
				sort = sort.ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sort);
		
		Page<Food> result = foodService.searchFood(userId, query, pageable);
		
		return result;
	}

	@GetMapping("/{id}")
	public Food getFoodById(@PathVariable Long id) {
		return foodService.getOne(id).get();
	}

	@PostMapping
	public Food createFood(@RequestBody Food requestBody) {
		return foodService.save(requestBody);
	}

	@PutMapping("/{id}")
	public Boolean deactivateFood(@PathVariable Long id) {
		// TODO: obtener el userId del header??
		Long userId = 1L;

		return foodService.deactivateFood(id, userId) > 0;
	}
}
