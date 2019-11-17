package com.nutritech.nu34life.service;

import java.util.List;

public interface CrudService<T,D> {
	T getById(D id);
	List<T> getAll();
	T save(T entity);
	
}
