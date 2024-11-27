package com.bussiness.go.software.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bussiness.go.software.entities.commons.ListaSelector;
import com.bussiness.go.software.repositories.IListaSelectorRepository;
import com.bussiness.go.software.services.IListaSelectorService;
import com.bussiness.go.software.utilities.ConstantesApp;


@Service
public class ListaSelectorServiceImpl extends CommonServiceImpl<ListaSelector, IListaSelectorRepository, String> implements IListaSelectorService{

	@Autowired
	private IListaSelectorRepository iListaSelectorRepository;
	
	
	@Override
	public List<ListaSelector> consultarListaSelector(String nombreLista, Map<String, String> filtros) {
		String filtroLike = null;
		UUID paisId = null;
		UUID depaId = null;
		List<ListaSelector> listaSelector = new ArrayList<>();
		
		if (filtros.get(ConstantesApp.PARAM_URL_FILTRO_LIKE) != null) {
			filtroLike = "%" + filtros.get(ConstantesApp.PARAM_URL_FILTRO_LIKE) + "%";
		}
		if (filtros.get(ConstantesApp.PARAM_URL_FILTRO_PAIS_ID) != null) {
			paisId = UUID.fromString(filtros.get(ConstantesApp.PARAM_URL_FILTRO_PAIS_ID));
		}
		if (filtros.get(ConstantesApp.PARAM_URL_FILTRO_DEPARTAMENTO_ID) != null) {
			depaId = UUID.fromString(filtros.get(ConstantesApp.PARAM_URL_FILTRO_DEPARTAMENTO_ID));
		}
		
		switch(nombreLista) {			
			case ConstantesApp.END_POINT_API_TIPO_IDENTIFICACION:
				listaSelector = iListaSelectorRepository.consultarListaTipoIdentificacion();	
				break;
			case ConstantesApp.END_POINT_API_PAIS:
				listaSelector = iListaSelectorRepository.consultarListaPais();
				break;
			case ConstantesApp.END_POINT_API_DEPARTAMENTO_PAIS:
				listaSelector = iListaSelectorRepository.consultarListaDepartamentoPais(paisId);
				break;
			case ConstantesApp.END_POINT_API_CIUDAD_DEPARTAMENTO:
				listaSelector = iListaSelectorRepository.consultarListaCiudadDepartamento(depaId);
				break;
		}		
		return listaSelector;
	}

}
