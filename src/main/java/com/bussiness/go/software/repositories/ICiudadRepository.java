package com.bussiness.go.software.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, UUID>{

	public Optional<Ciudad> findByCiudIdAndCiudEstado(UUID ciudadId, String ciudEstado);
}
