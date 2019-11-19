package com.nutritech.nu34life.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.client.RecipeFeignClient;
import com.nutritech.nu34life.model.*;
import com.nutritech.nu34life.repository.DietRepository;
import com.nutritech.nu34life.service.DietService;
import com.nutritech.nu34life.util.Recipe;
@Service
public class DietServiceImpl implements DietService {

	@Autowired
	private RecipeFeignClient recipeFeignClient;
	@Autowired
	private DietRepository dietRepository;
	
	@Override
	public Diet save(Diet entity) {
		entity.getDietDays().forEach(x -> x.setDiet(entity));
		entity.getDietDays().forEach(x -> x.getDetails().forEach(y-> y.setDietDay(x)));
		entity.setCreationDate(LocalDate.now());
		return dietRepository.save(entity);
	}

	@Override
	public Optional<Diet> findById(Long id) {
		return dietRepository.findById(id);
	}

	@Override
	public List<Diet> findAll() {
		// TODO Auto-generated method stub
		
		return addNameRecipe(dietRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		dietRepository.deleteById(id);
	}
	
	@Override
	public Diet findDietsbyPatient(Long id){
		Diet d = dietRepository.findByPatientId(id);
		if(d != null) {
			for(DietDay dd : d.getDietDays()) {
				for(DietDayDetail ddd : dd.getDetails()) {
					if(ddd.getIdRecipe() != null)
					{
						Recipe recipe = recipeFeignClient.getRecipes(ddd.getIdRecipe().getId());
						ddd.setIdRecipe(recipe);
					}
				}
			}
		}
		return d;
	}
	
	private List<Diet> addNameRecipe(List<Diet> diets){
		if(diets == null) return null;
		
		for(Diet d : diets) {
			for(DietDay dd : d.getDietDays()) {
				for(DietDayDetail ddd : dd.getDetails()) {
					if(ddd.getIdRecipe() != null)
					{
						Recipe recipe = recipeFeignClient.getRecipes(ddd.getIdRecipe().getId());
						ddd.setIdRecipe(recipe);
					}
				}
			}
		}
		return diets;
	}
}
