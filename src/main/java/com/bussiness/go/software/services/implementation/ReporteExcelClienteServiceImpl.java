package com.bussiness.go.software.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bussiness.go.software.entities.commons.ReporteExcelClienteModel;
import com.bussiness.go.software.repositories.IReporteExcelClienteRepository;
import com.bussiness.go.software.services.IReporteExcelClienteService;

@Service
public class ReporteExcelClienteServiceImpl extends CommonServiceImpl<ReporteExcelClienteModel, IReporteExcelClienteRepository, Long> implements IReporteExcelClienteService{

	@Autowired
	private IReporteExcelClienteRepository iReporteExcelClienteRepository;
	
	@Override
	public List<ReporteExcelClienteModel> consultarClientes(String estado) {
		return iReporteExcelClienteRepository.consultarClientes(estado);
	}

}


