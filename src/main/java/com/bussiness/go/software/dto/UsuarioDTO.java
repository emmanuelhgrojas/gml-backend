package com.bussiness.go.software.dto;

import java.util.Date;
import java.util.UUID;

import com.bussiness.go.software.entities.commons.Usuario;

public class UsuarioDTO {

	private UUID usuaId;
	private String usuaEmail;
	private String usuaEstado;	
	private Date usuaFecha;
	private String usuaPassword;
	private String usuaUsername;
	private String usuaNombres;
	private String usuaApellidos;
	private UUID rolId;
	
	
	public UsuarioDTO() {
	}	

	public UsuarioDTO(UUID usuaId, String usuaEmail, String usuaEstado, Date usuaFecha, String usuaPassword,
			String usuaUsername, String usuaNombres, String usuaApellidos, UUID rolId) {
		super();
		this.usuaId = usuaId;
		this.usuaEmail = usuaEmail;
		this.usuaEstado = usuaEstado;
		this.usuaFecha = usuaFecha;
		this.usuaPassword = usuaPassword;
		this.usuaUsername = usuaUsername;
		this.usuaNombres = usuaNombres;
		this.usuaApellidos = usuaApellidos;
		this.rolId = rolId;
	}

	public UUID getUsuaId() {
		return usuaId;
	}

	public void setUsuaId(UUID usuaId) {
		this.usuaId = usuaId;
	}

	public String getUsuaEmail() {
		return usuaEmail;
	}

	public void setUsuaEmail(String usuaEmail) {
		this.usuaEmail = usuaEmail;
	}

	public String getUsuaEstado() {
		return usuaEstado;
	}

	public void setUsuaEstado(String usuaEstado) {
		this.usuaEstado = usuaEstado;
	}

	public Date getUsuaFecha() {
		return usuaFecha;
	}

	public void setUsuaFecha(Date usuaFecha) {
		this.usuaFecha = usuaFecha;
	}

	public String getUsuaPassword() {
		return usuaPassword;
	}

	public void setUsuaPassword(String usuaPassword) {
		this.usuaPassword = usuaPassword;
	}

	public String getUsuaUsername() {
		return usuaUsername;
	}

	public void setUsuaUsername(String usuaUsername) {
		this.usuaUsername = usuaUsername;
	}	
	
	public String getUsuaNombres() {
		return usuaNombres;
	}

	public void setUsuaNombres(String usuaNombres) {
		this.usuaNombres = usuaNombres;
	}

	public String getUsuaApellidos() {
		return usuaApellidos;
	}

	public void setUsuaApellidos(String usuaApellidos) {
		this.usuaApellidos = usuaApellidos;
	}
	
	public UUID getRolId() {
		return rolId;
	}

	public void setRolId(UUID rolId) {
		this.rolId = rolId;
	}

	public Usuario toBO() {
		Usuario usuario = new Usuario();
		usuario.setUsuaEmail(usuaEmail);
		usuario.setUsuaEstado(usuaEstado);
		usuario.setUsuaFecha(usuaFecha);
		usuario.setUsuaId(usuaId);
		usuario.setUsuaPassword(usuaPassword);
		usuario.setUsuaUsername(usuaUsername);
		usuario.setUsuaNombres(usuaNombres);
		usuario.setUsuaApellidos(usuaApellidos);
		return usuario;
	}
}
