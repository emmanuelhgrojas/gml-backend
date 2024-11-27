package com.bussiness.go.software.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bussiness.go.software.entities.commons.Usuario;
import com.bussiness.go.software.repositories.IUsuarioRepositoryPaging;
import com.bussiness.go.software.services.IUsuarioServicePaging;

@Service
public class UsuarioServiceImplPaging implements IUsuarioServicePaging{

	@Autowired
	private IUsuarioRepositoryPaging iUsuarioRepositoryPaging;
	
	@Override
	public List<Usuario> findPaginated(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Usuario> pagedResult = iUsuarioRepositoryPaging.findAll(paging);
        return pagedResult.toList();
	}

}
