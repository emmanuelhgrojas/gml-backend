package com.bussiness.go.software.security;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bussiness.go.software.utilities.ApiResponse;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.MensajesApp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/auth")
public class AuthController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private TokenUtils tokenUtils;

	@PostMapping("/iniciar-sesion")
	public ApiResponse<AuthAuthenticateDTO> authenticateUser(@Valid @RequestBody AuthCredentialsDTO authCredentials) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authCredentials.getUsername(), authCredentials.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
			String jwtToken = tokenUtils.createToken(userPrincipal.getUsername(), userPrincipal.getUserEmail());		
					
			List<String> roles = userPrincipal.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			AuthAuthenticateDTO authAuthenticateDTO = new AuthAuthenticateDTO();
			authAuthenticateDTO.setJwtToken(jwtToken);
			authAuthenticateDTO.setUsuaEmail(userPrincipal.getUserEmail());
			authAuthenticateDTO.setUsuaEstado(userPrincipal.getUsuaEstado());
			authAuthenticateDTO.setUsuaFecha(userPrincipal.getUsuaFecha());
			authAuthenticateDTO.setUsuaId(userPrincipal.getUsuaId());
			authAuthenticateDTO.setUsuaUsername(userPrincipal.getUsername());			
			return new ApiResponse<>(HttpStatus.OK.value(), MensajesApp.AUTH_SUCCESS, authAuthenticateDTO);
		}catch(BadCredentialsException e) {
			return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), MensajesApp.AUTH_UNAUTHORIZED, null);
		}		
	}
}















