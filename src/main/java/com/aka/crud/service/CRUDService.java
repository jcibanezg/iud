package com.aka.crud.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<E> {
	List<E> getAll();

	E get(Serializable id);
	
	E create(E entity);

	E update(E entity);	

	void remove(Serializable id);
}
