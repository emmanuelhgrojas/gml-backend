package com.bussiness.go.software.services;

import java.util.List;

import com.bussiness.go.software.entities.commons.Usuario;

public interface IUsuarioServicePaging {

	List<Usuario> findPaginated(Integer pageNo, Integer pageSize);
}
