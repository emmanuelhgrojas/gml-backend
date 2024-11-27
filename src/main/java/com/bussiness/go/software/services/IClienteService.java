package com.bussiness.go.software.services;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import com.bussiness.go.software.dto.ClienteDTO;
import com.bussiness.go.software.dto.DataTablesRequest;
import com.bussiness.go.software.dto.DataTablesResponse;
import com.bussiness.go.software.entities.commons.Cliente;
import com.bussiness.go.software.utilities.FunctionResponse;

public interface IClienteService extends CommonService<Cliente, UUID>{
	
	Optional<Cliente> findOneByClieIdAndClieEstado(UUID clieId, String clieEstado);

	FunctionResponse<ClienteDTO> consultarClientePorId(UUID clieId);
	
	DataTablesResponse listarTodosLosClientes(DataTablesRequest dataTablesRequest);
	
	FunctionResponse<ClienteDTO> guardarCliente(ClienteDTO clienteDTO) throws RuntimeException, SQLException;
}
