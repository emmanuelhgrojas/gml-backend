package com.bussiness.go.software.entities.commons;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.bussiness.go.software.dto.BandejaUsuarioDTO;

@Entity
public class BandejaUsuarioModel {

	@Id
	private UUID usuaId;	
	private String usuaEmail;	
	private String usuaUsername;
	
	
	public BandejaUsuarioModel() {
	}
	
	public BandejaUsuarioModel(UUID usuaId, String usuaEmail, String usuaUsername) {
		this.usuaId = usuaId;
		this.usuaEmail = usuaEmail;
		this.usuaUsername = usuaUsername;
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

	public BandejaUsuarioDTO toBO() {
		BandejaUsuarioDTO bandejaUsuarioDTO = new BandejaUsuarioDTO();
		bandejaUsuarioDTO.setUsuaEmail(usuaEmail);
		bandejaUsuarioDTO.setUsuaId(usuaId);
		bandejaUsuarioDTO.setUsuaUsername(usuaUsername);
		return bandejaUsuarioDTO;
	}
}
