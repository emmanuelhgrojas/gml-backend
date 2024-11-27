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

import com.bussiness.go.software.dto.DataTablesRequest;
import com.bussiness.go.software.dto.DataTablesResponse;
import com.bussiness.go.software.dto.UsuarioDTO;
import com.bussiness.go.software.entities.commons.Usuario;
import com.bussiness.go.software.services.IUsuarioService;
import com.bussiness.go.software.utilities.ApiResponse;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.FunctionResponse;
import com.bussiness.go.software.utilities.MensajesApp;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/usuario")
public class UsuarioController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	/**
	 * Devuelve el usuarioDTO consultado por el ID recibido como parametro
	 * 
	 * @param usuaId
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Consultar el UsuarioDTO", description = "Devuelve el usuarioDTO consultado por el ID recibido como parametro")
	@GetMapping("/{usuaId}")
	public ApiResponse<UsuarioDTO> consultarUsuarioPorId(@PathVariable UUID usuaId) {
		try {
			FunctionResponse<UsuarioDTO> functionResponse = iUsuarioService.consultarUsuarioPorId(usuaId);
			return new ApiResponse<>(functionResponse.getStatus(), functionResponse.getMessage(), functionResponse.getResult());	
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), MensajesApp.ERROR_PETICION);
		}
	}
	
	/**
	 * Elimina el usuarioDTO consultado por el ID recibido como parametro
	 * 
	 * @param usuaId
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Eliminar el UsuarioDTO", description = "Elimina el usuarioDTO consultado por el ID recibido como parametro")
	@DeleteMapping("/{usuaId}")
	public ApiResponse<UsuarioDTO> eliminarUsuarioId(@PathVariable UUID usuaId) {
		try {
			Optional<Usuario> usuarioOptional = iUsuarioService.findOneByUsuaIdAndUsuaEstado(usuaId, ConstantesApp.ESTADO_REGISTRO_ACTIVO);
			if (usuarioOptional.isPresent()) {
				Usuario usuarioModel = usuarioOptional.get();				
				usuarioModel.setUsuaEstado(ConstantesApp.ESTADO_REGISTRO_INACTIVO);
				iUsuarioService.save(usuarioModel);
				return new ApiResponse<>(HttpStatus.OK.value(), MensajesApp.USUARIO_ELIMINADO_SUCCESS, null);			
			} else {
				return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), MensajesApp.USUARIO_404, null);
			}
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), MensajesApp.ERROR_PETICION);
		}
	}
	
	
	/**
	 * Guarda la información del usuario
	 * @return
	 */
	@Operation(summary = "Guardar Usuario", description = "Guardar la información del usuario")
	@PostMapping("/guardar")
	@ResponseBody
	public ApiResponse<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO){
		try {
			if(usuarioDTO != null) {
				FunctionResponse<UsuarioDTO> functionResponse = iUsuarioService.guardarUsuario(usuarioDTO);
				if(functionResponse != null) {
					return new ApiResponse<>(functionResponse.getStatus(), functionResponse.getMessage(), functionResponse.getResult());
				}				
				return new ApiResponse<>(HttpStatus.OK.value(), MensajesApp.USUARIO_SAVE_SUCCESS, null);
			}
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), MensajesApp.HTTP_400, null);	
		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.CONFLICT.value(), e.getMessage(), null);
		}
	}
	
	/**
	 * Devuelve la lista de todos los usuarios activos
	 * @author Ingeniero Emmanuel Gamboa R.
	 * @return
	 */
	@Operation(summary = "Listar todos los usuarios", description = "Consultar todos los usuarios registrados en el sistema")
	@PostMapping("/")
	@ResponseBody
	public DataTablesResponse listarTodosLosUsuarios(@RequestBody DataTablesRequest dataTablesRequest){
		return iUsuarioService.listarTodosLosUsuarios(dataTablesRequest);
	}
}

