package com.bussiness.go.software.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.Departamento;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, UUID>{

	public Optional<Departamento> findByDepaIdAndDepaEstado(UUID depaId, String depaEstado);
}
