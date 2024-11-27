package com.bussiness.go.software.controllers;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bussiness.go.software.dto.ClienteDTO;
import com.bussiness.go.software.dto.DataTablesRequest;
import com.bussiness.go.software.dto.DataTablesResponse;
import com.bussiness.go.software.entities.commons.Cliente;
import com.bussiness.go.software.services.IClienteService;
import com.bussiness.go.software.utilities.ApiResponse;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.FunctionResponse;
import com.bussiness.go.software.utilities.MensajesApp;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private IClienteService iClienteService;
	
	/**
	 * Devuelve el clienteDTO consultado por el ID recibido como parametro
	 * 
	 * @param clieId
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Consultar el ClienteDTO", description = "Devuelve el ClienteDTO consultado por el ID recibido como parametro")
	@GetMapping("/{clieId}")
	public ApiResponse<ClienteDTO> consultarClientePorId(@PathVariable UUID clieId) {
		LOGGER.info("consultarClientePorId -> clienteId: " + clieId);
		try {
			FunctionResponse<ClienteDTO> functionResponse = iClienteService.consultarClientePorId(clieId);
			return new ApiResponse<>(functionResponse.getStatus(), functionResponse.getMessage(), functionResponse.getResult());	
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), MensajesApp.ERROR_PETICION);
		}
	}
	
	/**
	 * Elimina el ClienteDTO consultado por el ID recibido como parametro
	 * 
	 * @param usuaId
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Eliminar el ClienteDTO", description = "Elimina el ClienteDTO consultado por el ID recibido como parametro")
	@DeleteMapping("/{clieId}")
	public ApiResponse<ClienteDTO> eliminarCliente(@PathVariable UUID clieId) {
		LOGGER.info("eliminarCliente -> clienteId: " + clieId);
		try {
			Optional<Cliente> clienteOptional = iClienteService.findOneByClieIdAndClieEstado(clieId, ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			if (clienteOptional.isPresent()) {
				Cliente clienteModel = clienteOptional.get();				
				clienteModel.setClieEstado(ConstantesApp.ESTADO_REGISTRO_INACTIVO);
				iClienteService.save(clienteModel);
				return new ApiResponse<>(HttpStatus.OK.value(), MensajesApp.CLIENTE_ELIMINADO_SUCCESS, null);			
			} else {
				return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), MensajesApp.CLIENTE_404, null);
			}
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), MensajesApp.ERROR_PETICION);
		}
	}
	
	
	/**
	 * Guarda la información del cliente
	 * @return
	 */
	@Operation(summary = "Guardar Cliente", description = "Guardar la información del cliente")
	@PostMapping("/guardar")
	@ResponseBody
	public ApiResponse<ClienteDTO> guardarCliente(@RequestBody ClienteDTO clienteDTO){
		LOGGER.info("guardarCliente");
		try {
			if(clienteDTO != null) {
				FunctionResponse<ClienteDTO> functionResponse = iClienteService.guardarCliente(clienteDTO);
				if(functionResponse != null) {
					return new ApiResponse<>(functionResponse.getStatus(), functionResponse.getMessage(), functionResponse.getResult());
				}				
				return new ApiResponse<>(HttpStatus.OK.value(), MensajesApp.CLIENTE_SAVE_SUCCESS, null);
			}
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), MensajesApp.HTTP_400, null);	
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), null);
		}
	}
	
	/**
	 * Devuelve la lista de todos los clientes activos
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Listar todos los clientes", description = "Consultar todos los clientes registrados en el sistema")
	@PostMapping("/")
	@ResponseBody
	public DataTablesResponse listarTodosLosClientes(@RequestBody DataTablesRequest dataTablesRequest){
		LOGGER.info("listarTodosLosClientes");
		return iClienteService.listarTodosLosClientes(dataTablesRequest);
	}
}
