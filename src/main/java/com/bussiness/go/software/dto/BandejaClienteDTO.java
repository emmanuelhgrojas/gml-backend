package com.bussiness.go.software.dto;

import java.util.UUID;

import com.bussiness.go.software.entities.commons.BandejaClienteModel;

public class BandejaClienteDTO {

	private UUID clieId;
	private String clieSharedKey;
	private String clieNombre;	
	private String clieEmail;
	private String cliePhone;
	private String fecha;
	
	public BandejaClienteDTO() {
	}

	public BandejaClienteDTO(UUID clieId, String clieSharedKey, String clieNombre, String clieEmail, String cliePhone,
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
	
	public BandejaClienteModel toBO() {
		BandejaClienteModel bandejaClienteModel = new BandejaClienteModel();
		bandejaClienteModel.setClieEmail(clieEmail);
		bandejaClienteModel.setClieId(clieId);
		bandejaClienteModel.setClieNombre(clieNombre);
		bandejaClienteModel.setCliePhone(cliePhone);
		bandejaClienteModel.setClieSharedKey(clieSharedKey);
		bandejaClienteModel.setFecha(fecha);
		return bandejaClienteModel;
	}	
}
