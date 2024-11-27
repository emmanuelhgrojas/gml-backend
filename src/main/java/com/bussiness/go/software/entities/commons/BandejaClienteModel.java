package com.bussiness.go.software.entities.commons;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.bussiness.go.software.dto.BandejaClienteDTO;

@Entity
public class BandejaClienteModel {

	@Id
	private UUID clieId;
	private String clieSharedKey;
	private String clieNombre;	
	private String clieEmail;
	private String cliePhone;
	private String fecha;
	
	public BandejaClienteModel() {
	}

	public BandejaClienteModel(UUID clieId, String clieSharedKey, String clieNombre, String clieEmail, String cliePhone,
			String fecha) {
		this.clieId = clieId;
		this.clieSharedKey = clieSharedKey;
		this.clieNombre = clieNombre;
		this.clieEmail = clieEmail;
		this.cliePhone = cliePhone;
		this.fecha = fecha;
	}

	public UUID getClieId() {
		return clieId;
	}

	public void setClieId(UUID clieId) {
		this.clieId = clieId;
	}

	public String getClieSharedKey() {
		return clieSharedKey;
	}

	public void setClieSharedKey(String clieSharedKey) {
		this.clieSharedKey = clieSharedKey;
	}

	public String getClieNombre() {
		return clieNombre;
	}

	public void setClieNombre(String clieNombre) {
		this.clieNombre = clieNombre;
	}

	public String getClieEmail() {
		return clieEmail;
	}

	public void setClieEmail(String clieEmail) {
		this.clieEmail = clieEmail;
	}

	public String getCliePhone() {
		return cliePhone;
	}

	public void setCliePhone(String cliePhone) {
		this.cliePhone = cliePhone;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}	
	
	public BandejaClienteDTO toBO() {
		BandejaClienteDTO bandejaClienteDTO = new BandejaClienteDTO();
		bandejaClienteDTO.setClieEmail(clieEmail);
		bandejaClienteDTO.setClieId(clieId);
		bandejaClienteDTO.setClieNombre(clieNombre);
		bandejaClienteDTO.setCliePhone(cliePhone);
		bandejaClienteDTO.setClieSharedKey(clieSharedKey);
		bandejaClienteDTO.setFecha(fecha);
		return bandejaClienteDTO;
	}	
}
