package com.bussiness.go.software.services.implementation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bussiness.go.software.dto.BandejaUsuarioDTO;
import com.bussiness.go.software.dto.DataTablesRequest;
import com.bussiness.go.software.dto.DataTablesResponse;
import com.bussiness.go.software.dto.UsuarioDTO;
import com.bussiness.go.software.entities.commons.BandejaUsuarioModel;
import com.bussiness.go.software.entities.commons.Usuario;
import com.bussiness.go.software.repositories.IUsuarioRepository;
import com.bussiness.go.software.services.IBandejaUsuarioService;
import com.bussiness.go.software.services.IUsuarioService;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.FunctionResponse;
import com.bussiness.go.software.utilities.MensajesApp;


@Service
public class UsuarioServiceImpl extends CommonServiceImpl <Usuario, IUsuarioRepository, UUID> implements IUsuarioService{

	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	@Autowired
	private IBandejaUsuarioService iBandejaUsuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<Usuario> findOneByUsuaUsernameOrUsuaEmailAndUsuaEstado(String usuaUsername, String usuaEmail,
			String usuaEstado) {
		return iUsuarioRepository.findOneByUsuaUsernameOrUsuaEmailAndUsuaEstado(usuaUsername, usuaEmail, usuaEstado);
	}

	@Override
	public Optional<Usuario> findOneByUsuaUsernameAndUsuaEstado(String usuaUsername, String usuaEstado) {
		return iUsuarioRepository.findOneByUsuaUsernameAndUsuaEstado(usuaUsername, usuaEstado);
	}

	@Override
	public Optional<Usuario> findOneByUsuaIdAndUsuaEstado(UUID usuaId, String usuaEstado) {
		return iUsuarioRepository.findOneByUsuaIdAndUsuaEstado(usuaId, usuaEstado);
	}

	@Override
	public FunctionResponse<UsuarioDTO> consultarUsuarioPorId(UUID usuaId) {
		try {
			Optional<Usuario> usuarioOptional = iUsuarioRepository.findOneByUsuaIdAndUsuaEstado(usuaId, ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			if (!usuarioOptional.isPresent()) {
				throw new Exception(MensajesApp.USUARIO_404);		
			}
			UsuarioDTO usuarioDTO = usuarioOptional.get().toBO();				
			usuarioDTO.setUsuaPassword(null);
			usuarioDTO.setUsuaFecha(null);
			return new FunctionResponse<>(HttpStatus.OK.value(), MensajesApp.USUARIO_SUCCESS, usuarioDTO);	
		} catch (Exception e) {
			return new FunctionResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), MensajesApp.ERROR_PETICION);
		}
	}

	@Override
	public DataTablesResponse listarTodosLosUsuarios(DataTablesRequest dataTablesRequest) {
		try { 	
			DataTablesResponse dataTablesResponse = new DataTablesResponse();
			List<BandejaUsuarioDTO> listaBandejaUsuarioDTO = new ArrayList<>();
			List<String> listaStringBandejaUsuarioDTO = new ArrayList<>();
			List<BandejaUsuarioModel> listaUsuariosBandejaSinFiltro = iBandejaUsuarioService.totalListaUsuariosPorEstado(ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			List<BandejaUsuarioModel> listaUsuariosBandeja = new ArrayList<>();
			
			if(!dataTablesRequest.getSearch().getValue().isEmpty()) {
				listaUsuariosBandeja = iBandejaUsuarioService.listaUsuariosPorEstadoConFiltro(dataTablesRequest.getSearch().getValue(), ConstantesApp.ESTADO_REGISTRO_ACTIVO, dataTablesRequest.getLength(), dataTablesRequest.getStart());
			}else {
				listaUsuariosBandeja = iBandejaUsuarioService.listaUsuariosPorEstadoSinFiltro(ConstantesApp.ESTADO_REGISTRO_ACTIVO, dataTablesRequest.getLength(), dataTablesRequest.getStart());
			}		
			if(!listaUsuariosBandeja.isEmpty()) {
				listaUsuariosBandeja.forEach(bandejaUsuario -> {
					BandejaUsuarioDTO bandejaUsuarioDTO = new BandejaUsuarioDTO();
					bandejaUsuarioDTO.setUsuaEmail(bandejaUsuario.getUsuaEmail());
					bandejaUsuarioDTO.setUsuaId(bandejaUsuario.getUsuaId());
					bandejaUsuarioDTO.setUsuaUsername(bandejaUsuario.getUsuaUsername());
					listaBandejaUsuarioDTO.add(bandejaUsuarioDTO);
				});
			}	
			dataTablesResponse.setData(listaBandejaUsuarioDTO);
			dataTablesResponse.setDraw(dataTablesRequest.getLength());
			if(!dataTablesRequest.getSearch().getValue().isEmpty()) {
				dataTablesResponse.setRecordsFiltered(listaUsuariosBandeja.size());
			}else {
				dataTablesResponse.setRecordsFiltered(listaUsuariosBandejaSinFiltro.size());
			}
			dataTablesResponse.setRecordsTotal(listaUsuariosBandejaSinFiltro.size());
			return dataTablesResponse;
		} catch (Exception e) {
			return null;
		} 
	}

	@Transactional( rollbackFor = {SQLException.class, Exception.class})
	@Override
	public FunctionResponse<UsuarioDTO> guardarUsuario(UsuarioDTO usuarioDTO) throws RuntimeException, SQLException{
		Usuario usuarioModel = new Usuario();	
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		if(usuarioDTO.getUsuaId() != null) {
			Optional<Usuario> usuarioOptional = iUsuarioRepository.findOneByUsuaIdAndUsuaEstado(usuarioDTO.getUsuaId(), ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			if (!usuarioOptional.isPresent()) {
				throw new RuntimeException(MensajesApp.USUARIO_404);
			}
			usuarioModel = usuarioOptional.get();
		}else {
			usuarioModel.setUsuaUsername(usuarioDTO.getUsuaUsername());	
			usuarioModel.setUsuaEstado(ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			usuarioModel.setUsuaFecha(timestamp);
		}			
		if(usuarioDTO.getUsuaPassword() != null) {
			usuarioModel.setUsuaPassword(passwordEncoder.encode(usuarioDTO.getUsuaPassword()));
		}
		usuarioModel.setUsuaApellidos(usuarioDTO.getUsuaApellidos());
		usuarioModel.setUsuaEmail(usuarioDTO.getUsuaEmail());
		usuarioModel.setUsuaNombres(usuarioDTO.getUsuaNombres());			
		iUsuarioRepository.save(usuarioModel);
		return new FunctionResponse<>(HttpStatus.OK.value(), MensajesApp.USUARIO_SAVE_SUCCESS, null);	
	}

}
