package com.bussiness.go.software.services.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bussiness.go.software.controllers.ClienteController;
import com.bussiness.go.software.dto.BandejaClienteDTO;
import com.bussiness.go.software.dto.BandejaUsuarioDTO;
import com.bussiness.go.software.dto.ClienteDTO;
import com.bussiness.go.software.dto.DataTablesRequest;
import com.bussiness.go.software.dto.DataTablesResponse;
import com.bussiness.go.software.entities.commons.BandejaClienteModel;
import com.bussiness.go.software.entities.commons.BandejaUsuarioModel;
import com.bussiness.go.software.entities.commons.Cliente;
import com.bussiness.go.software.repositories.IClienteRepository;
import com.bussiness.go.software.services.IBandejaClienteService;
import com.bussiness.go.software.services.IClienteService;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.FunctionResponse;
import com.bussiness.go.software.utilities.MensajesApp;

@Service
public class ClienteServiceImpl extends CommonServiceImpl <Cliente, IClienteRepository, UUID> implements IClienteService{

	public static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Autowired
	private IBandejaClienteService iBandejaClienteService;
	
	@Override
	public Optional<Cliente> findOneByClieIdAndClieEstado(UUID clieId, String clieEstado) {
		return iClienteRepository.findOneByClieIdAndClieEstado(clieId, clieEstado);
	}

	@Override
	public FunctionResponse<ClienteDTO> consultarClientePorId(UUID clieId) {
		LOGGER.info("consultarClientePorId");
		try {
			Optional<Cliente> clienteOptional = iClienteRepository.findOneByClieIdAndClieEstado(clieId, ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			if (!clienteOptional.isPresent()) {
				throw new Exception(MensajesApp.CLIENTE_404);		
			}
			LOGGER.info("Se encontro el cliente");
			ClienteDTO clienteDTO = clienteOptional.get().toBO();
			return new FunctionResponse<>(HttpStatus.OK.value(), MensajesApp.CLIENTE_SUCCESS, clienteDTO);	
		} catch (Exception e) {
			return new FunctionResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), MensajesApp.ERROR_PETICION);
		}
	}

	@Override
	public DataTablesResponse listarTodosLosClientes(DataTablesRequest dataTablesRequest) {
		try { 	
			LOGGER.info("listarTodosLosClientes");
			DataTablesResponse dataTablesResponse = new DataTablesResponse();
			List<BandejaClienteDTO> listaBandejaClienteDTO = new ArrayList<>();
			List<String> listaStringClienteUsuarioDTO = new ArrayList<>();
			List<BandejaClienteModel> listaClienteBandejaSinFiltro = iBandejaClienteService.totalListaClientesPorEstado(ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			List<BandejaClienteModel> listaClienteBandeja = new ArrayList<>();
			
			if(!dataTablesRequest.getSearch().getValue().isEmpty()) {
				listaClienteBandeja = iBandejaClienteService.listaClientesPorEstadoConFiltro(dataTablesRequest.getSearch().getValue(), ConstantesApp.ESTADO_REGISTRO_ACTIVO, dataTablesRequest.getLength(), dataTablesRequest.getStart());
			}else {
				listaClienteBandeja = iBandejaClienteService.listaClientesPorEstadoSinFiltro(ConstantesApp.ESTADO_REGISTRO_ACTIVO, dataTablesRequest.getLength(), dataTablesRequest.getStart());
			}		
			if(!listaClienteBandeja.isEmpty()) {
				listaClienteBandeja.forEach(bandejaCliente -> {
					BandejaClienteDTO bandejaClienteDTO = new BandejaClienteDTO();
					bandejaClienteDTO.setClieEmail(bandejaCliente.getClieEmail());
					bandejaClienteDTO.setClieId(bandejaCliente.getClieId());
					bandejaClienteDTO.setClieNombre(bandejaCliente.getClieNombre());
					bandejaClienteDTO.setCliePhone(bandejaCliente.getCliePhone());
					bandejaClienteDTO.setClieSharedKey(bandejaCliente.getClieSharedKey());
					bandejaClienteDTO.setFecha(bandejaCliente.getFecha());
					listaBandejaClienteDTO.add(bandejaClienteDTO);
				});
			}	
			dataTablesResponse.setData(listaBandejaClienteDTO);
			dataTablesResponse.setDraw(dataTablesRequest.getLength());
			if(!dataTablesRequest.getSearch().getValue().isEmpty()) {
				dataTablesResponse.setRecordsFiltered(listaClienteBandeja.size());
			}else {
				dataTablesResponse.setRecordsFiltered(listaClienteBandejaSinFiltro.size());
			}
			dataTablesResponse.setRecordsTotal(listaClienteBandejaSinFiltro.size());
			LOGGER.info("lista de clientes encontrada");
			return dataTablesResponse;
		} catch (Exception e) {
			return null;
		} 
	}

	@Override
	public FunctionResponse<ClienteDTO> guardarCliente(ClienteDTO clienteDTO) throws RuntimeException, SQLException {
		LOGGER.info("guardarCliente");
		Cliente clienteModel = new Cliente();	
		if(clienteDTO.getClieId() != null) {
			Optional<Cliente> clienteOptional = iClienteRepository.findOneByClieIdAndClieEstado(clienteDTO.getClieId(), ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			if (!clienteOptional.isPresent()) {
				throw new RuntimeException(MensajesApp.CLIENTE_404);
			}
			clienteModel = clienteOptional.get();
		}else {	
			clienteModel.setClieEstado(ConstantesApp.ESTADO_REGISTRO_ACTIVO);
		}					
		clienteModel.setClieNombre(clienteDTO.getClieNombre());
		clienteModel.setClieEmail(clienteDTO.getClieEmail());
		clienteModel.setClieStartDate(clienteDTO.getClieStartDate());
		clienteModel.setClieEndDate(clienteDTO.getClieEndDate());		
		clienteModel.setCliePhone(clienteDTO.getCliePhone());
		clienteModel.setClieSharedKey(clienteDTO.getClieSharedKey());
		iClienteRepository.save(clienteModel);
		LOGGER.info("cliente guardado");
		return new FunctionResponse<>(HttpStatus.OK.value(), MensajesApp.USUARIO_SAVE_SUCCESS, null);	
	}

}
