package com.bussiness.go.software.services.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.BandejaUsuarioModel;
import com.bussiness.go.software.repositories.IBandejaUsuarioRepository;
import com.bussiness.go.software.services.IBandejaUsuarioService;

@Repository
public class BandejaUsuarioServiceImpl extends CommonServiceImpl<BandejaUsuarioModel, IBandejaUsuarioRepository, UUID> implements IBandejaUsuarioService{

	@Autowired
	private IBandejaUsuarioRepository iBandejaUsuarioRepository;
	
	@Override
	public List<BandejaUsuarioModel> listaUsuariosPorEstadoConFiltro(String filtro, String estado, Integer limitQuery, Integer offsetQuery) {
		return iBandejaUsuarioRepository.listaUsuariosPorEstadoConFiltro(filtro, estado, limitQuery, offsetQuery);
	}

	@Override
	public List<BandejaUsuarioModel> totalListaUsuariosPorEstado(String estado) {
		return iBandejaUsuarioRepository.totalListaUsuariosPorEstado(estado);
	}

	@Override
	public List<BandejaUsuarioModel> listaUsuariosPorEstadoSinFiltro(String estado, Integer limitQuery, Integer offsetQuery) {
		return iBandejaUsuarioRepository.listaUsuariosPorEstadoSinFiltro(estado, limitQuery, offsetQuery);
	}
}
