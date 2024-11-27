package com.bussiness.go.software.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bussiness.go.software.dto.ListaSelectorDTO;
import com.bussiness.go.software.entities.commons.ListaSelector;
import com.bussiness.go.software.services.IListaSelectorService;
import com.bussiness.go.software.utilities.ApiResponse;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.MensajesApp;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/lista-selector")
public class ListaSelectorController {

	@Autowired
	private IListaSelectorService iListaSelectorService;
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ListaSelectorController.class);
	
	/**
	 * Devuelve una lista de ListaSelectorDTO por el NOMBRE_LISTA pasado como parametro
	 * 
	 * @param nombreLista
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Consultar la Lista Selector", description = "Devuelve una lista de ListaSelectorDTO por el nombre de la LISTA pasada como parametro")
	@GetMapping("/menu")
	@ResponseBody
	public ApiResponse<List<ListaSelectorDTO>> consultarListaSelectorPublica(
			@RequestParam(value = "nombreLista", required = true) String nombreLista,
			@RequestParam(value = "paisId", required = false) String paisId,
			@RequestParam(value = "depaId", required = false) String depaId
			){
		return consultaListaSelector(nombreLista, paisId, depaId);
	}
	
	/**
	 * Devuelve una lista de ListaSelectorDTO por el NOMBRE_LISTA pasado como parametro privada
	 * 
	 * @param nombreLista
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Consultar la Lista Selector", description = "Devuelve una lista de ListaSelectorDTO por el nombre de la LISTA pasada como parametro")
	@GetMapping("/opcion")
	@ResponseBody
	public ApiResponse<List<ListaSelectorDTO>> consultarListaSelectorPrivada(
			@RequestParam(value = "nombreLista", required = true) String nombreLista,
			@RequestParam(value = "paisId", required = false) String paisId,
			@RequestParam(value = "depaId", required = false) String depaId
			){
		return consultaListaSelector(nombreLista, paisId, depaId);
	}
	
	public ApiResponse<List<ListaSelectorDTO>> consultaListaSelector(String nombreLista, String paisId, String depaId) {
		try { 			
			Map<String, String> listaFiltros = new HashMap<>();			
			listaFiltros.put(ConstantesApp.PARAM_URL_FILTRO_PAIS_ID, paisId); //This is a example of param of URL for filter in query SQL
			listaFiltros.put(ConstantesApp.PARAM_URL_FILTRO_DEPARTAMENTO_ID, depaId); 
			List<ListaSelectorDTO> listaSelectorDTO = new ArrayList<>();			
			if(nombreLista == null){
				throw new Exception(MensajesApp.MENU_SELECTOR_404);
			}
			List<ListaSelector> listaSelector = iListaSelectorService.consultarListaSelector(nombreLista, listaFiltros);
			if (listaSelector.isEmpty()) {
				throw new Exception(MensajesApp.LISTA_404);
			}				
			listaSelector.forEach(selector -> listaSelectorDTO.add(selector.toBO()));			
			return new ApiResponse<>(HttpStatus.OK.value(), MensajesApp.LISTA_CARGADA, listaSelectorDTO);			
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), null);
		} 
	}
}






