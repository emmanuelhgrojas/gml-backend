package com.bussiness.go.software.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bussiness.go.software.entities.commons.Usuario;
import com.bussiness.go.software.repositories.IUsuarioRepository;
import com.bussiness.go.software.utilities.ConstantesApp;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioRepository
			.findOneByUsuaUsernameOrUsuaEmailAndUsuaEstado(username, username, ConstantesApp.ESTADO_REGISTRO_ACTIVO)
			.orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));
		return new UserDetailsImpl(usuario);
	}

}
