package com.bussiness.go.software.services;

import java.util.List;
import java.util.Map;

import com.bussiness.go.software.entities.commons.ListaSelector;

public interface IListaSelectorService extends CommonService<ListaSelector, String>{

	public List<ListaSelector> consultarListaSelector(String nombreLista, Map<String, String> filtros);
}
