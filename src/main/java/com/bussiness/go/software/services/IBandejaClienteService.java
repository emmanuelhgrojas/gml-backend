package com.bussiness.go.software.services;

import java.util.List;
import java.util.UUID;

import com.bussiness.go.software.entities.commons.BandejaClienteModel;

public interface IBandejaClienteService extends CommonService<BandejaClienteModel, UUID>{

	public List<BandejaClienteModel> listaClientesPorEstadoConFiltro(String filtro, String estado, Integer limitQuery,
			Integer offsetQuery);

	public List<BandejaClienteModel> listaClientesPorEstadoSinFiltro(String estado, Integer limitQuery,
			Integer offsetQuery);

	public List<BandejaClienteModel> totalListaClientesPorEstado(String estado);
}
