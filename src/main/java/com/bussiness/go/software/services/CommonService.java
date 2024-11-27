package com.bussiness.go.software.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 *  
 *
 * @param <E> entidad 
 * @param <I> tipo llave primaria
 */
public interface CommonService<E, I> {
	
	public List<E> findAll();
	
	public Page<E> findAll(Pageable pageable);
	
	public Optional<E> findById(I id);
	
	public E save(E entity);
	
	public void deleteById(I id);

}

