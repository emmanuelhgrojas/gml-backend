package com.bussiness.go.software.services;

import java.util.List;

import com.bussiness.go.software.entities.commons.ReporteExcelClienteModel;

public interface IReporteExcelClienteService extends CommonService<ReporteExcelClienteModel, Long>{

	public List<ReporteExcelClienteModel> consultarClientes(String estado);
}
