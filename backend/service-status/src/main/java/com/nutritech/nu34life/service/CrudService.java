package com.nutritech.nu34life.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
	T save(T entity);
	Optional<T> findById(ID id);
	List<T> findAll();
	void delete(ID id);
}
