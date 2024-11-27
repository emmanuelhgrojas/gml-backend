package com.bussiness.go.software.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.Cliente;
import com.bussiness.go.software.entities.commons.Usuario;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, UUID>{

	Optional<Cliente> findOneByClieIdAndClieEstado(UUID clieId, String usuaEstado);
}
