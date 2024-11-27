package com.bussiness.go.software.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.Usuario;

@Repository
public interface IUsuarioRepositoryPaging extends PagingAndSortingRepository<Usuario, UUID>{

}
