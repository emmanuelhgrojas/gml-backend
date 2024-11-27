package com.bussiness.go.software.services.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.BandejaClienteModel;
import com.bussiness.go.software.repositories.IBandejaClienteRepository;
import com.bussiness.go.software.services.IBandejaClienteService;

@Repository
public class BandejaClienteServiceImpl extends CommonServiceImpl<BandejaClienteModel, IBandejaClienteRepository, UUID> implements IBandejaClienteService{

	@Autowired
	private IBandejaClienteRepository iBandejaClienteRepository;
	
	@Override
	public List<BandejaClienteModel> listaClientesPorEstadoConFiltro(String filtro, String estado, Integer limitQuery,
			Integer offsetQuery) {
		return iBandejaClienteRepository.listaClientesPorEstadoConFiltro(filtro, estado, limitQuery, offsetQuery);
	}

	@Override
	public List<BandejaClienteModel> listaClientesPorEstadoSinFiltro(String estado, Integer limitQuery,
			Integer offsetQuery) {
		return iBandejaClienteRepository.listaClientesPorEstadoSinFiltro(estado, limitQuery, offsetQuery);
	}

	@Override
	public List<BandejaClienteModel> totalListaClientesPorEstado(String estado) {
		return iBandejaClienteRepository.totalListaClientesPorEstado(estado);
	}

}
