package com.bussiness.go.software.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bussiness.go.software.services.CommonService;


public class CommonServiceImpl<E, R extends JpaRepository<E, I>, I > implements CommonService<E, I> {

	@Autowired
	protected R repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<E> findAll() {
		return repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(I id) {
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {
		return repositorio.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(I id) {
		repositorio.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

}