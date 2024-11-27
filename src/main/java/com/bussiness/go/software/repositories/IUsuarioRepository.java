package com.bussiness.go.software.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID>{

	Optional<Usuario> findOneByUsuaUsernameOrUsuaEmailAndUsuaEstado(String usuaUsername, String usuaEmail, String usuaEstado);
	
	Optional<Usuario> findOneByUsuaUsernameAndUsuaEstado(String usuaUsername, String usuaEstado);
	
	Optional<Usuario> findOneByUsuaIdAndUsuaEstado(UUID usuaId, String usuaEstado);
}
