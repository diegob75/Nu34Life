package com.nutritech.nu34life.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
	
	T save(T  entity);

	List<T> getAll();

	Optional<T> getOne(ID id);
	
	void deleteById(ID id);
}
