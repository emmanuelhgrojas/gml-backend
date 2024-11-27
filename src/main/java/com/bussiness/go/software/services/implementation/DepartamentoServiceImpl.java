package com.bussiness.go.software.services.implementation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bussiness.go.software.entities.commons.Departamento;
import com.bussiness.go.software.repositories.IDepartamentoRepository;
import com.bussiness.go.software.services.IDepartamentoService;

@Service
public class DepartamentoServiceImpl extends CommonServiceImpl<Departamento, IDepartamentoRepository, UUID> implements IDepartamentoService{

	@Autowired
	private IDepartamentoRepository iDepartamentoRepository;
}
