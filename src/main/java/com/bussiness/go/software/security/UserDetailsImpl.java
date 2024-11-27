package com.bussiness.go.software.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bussiness.go.software.entities.commons.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

	private final Usuario usuario;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return usuario.getUsuaPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getUsuaUsername();
	}
	
	public String getUserEmail() {
		return usuario.getUsuaEmail();
	}
	
	public String getUsuaEstado() {
		return usuario.getUsuaEstado();
	}

	public Date getUsuaFecha() {
		return usuario.getUsuaFecha();
	}
	
	public UUID getUsuaId() {
		return usuario.getUsuaId();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
