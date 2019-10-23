package com.nutritech.nu34life.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritech.nu34life.model.entity.PkIngredient;
import com.nutritech.nu34life.model.repository.PKIngredientRepository;
import com.nutritech.nu34life.service.PKIngredientService;

@Service
public class PKIngredientServiceImpl implements PKIngredientService{

	@Autowired
	private PKIngredientRepository pkingredientRepository;
	
	@Transactional
	@Override
	public PkIngredient create(PkIngredient entity) {
		return pkingredientRepository.save(entity);
	}

	@Override
	public List<PkIngredient> getAll() {
		List<PkIngredient> pkIngredients = new ArrayList<>();
		pkingredientRepository.findAll().iterator().forEachRemaining(pkIngredients::add);
		return pkIngredients;
	}

	@Override
	public Optional<PkIngredient> getOne(Long id) {
		return pkingredientRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		pkingredientRepository.deleteById(id);
	}

}
