package com.bussiness.go.software.dto;

import java.util.UUID;

import com.bussiness.go.software.entities.commons.BandejaUsuarioModel;

public class BandejaUsuarioDTO {
	
	private UUID usuaId;	
	private String usuaEmail;	
	private String usuaUsername;
	private String rolNombre;
	
	
	public BandejaUsuarioDTO() {
	}
	
	public BandejaUsuarioDTO(UUID usuaId, String usuaEmail, String usuaUsername, String rolNombre) {
		this.usuaId = usuaId;
		this.usuaEmail = usuaEmail;
		this.usuaUsername = usuaUsername;
		this.rolNombre = rolNombre;
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

	public String getUsuaUsername() {
		return usuaUsername;
	}

	public void setUsuaUsername(String usuaUsername) {
		this.usuaUsername = usuaUsername;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}
	
	public BandejaUsuarioModel toBO() {
		BandejaUsuarioModel bandejaUsuarioModel = new BandejaUsuarioModel();
		bandejaUsuarioModel.setUsuaEmail(usuaEmail);
		bandejaUsuarioModel.setUsuaId(usuaId);
		bandejaUsuarioModel.setUsuaUsername(usuaUsername);
		return bandejaUsuarioModel;
	}
}