package com.bussiness.go.software.dto;

import java.util.Date;
import java.util.UUID;

import com.bussiness.go.software.entities.commons.Cliente;

public class ClienteDTO {

	private UUID clieId;
	private String clieNombre;
	private String clieEmail;
	private Date clieStartDate;
	private Date clieEndDate;
	private String clieEstado;
	private String clieSharedKey;
	private String cliePhone;
	
	public ClienteDTO() {
	}		

	public ClienteDTO(UUID clieId, String clieNombre, String clieEmail, Date clieStartDate, Date clieEndDate,
			String clieEstado, String clieSharedKey, String cliePhone) {
		this.clieId = clieId;
		this.clieNombre = clieNombre;
		this.clieEmail = clieEmail;
		this.clieStartDate = clieStartDate;
		this.clieEndDate = clieEndDate;
		this.clieEstado = clieEstado;
		this.clieSharedKey = clieSharedKey;
		this.cliePhone = cliePhone;
	}

	public UUID getClieId() {
		return clieId;
	}

	public void setClieId(UUID clieId) {
		this.clieId = clieId;
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

	public Date getClieStartDate() {
		return clieStartDate;
	}

	public void setClieStartDate(Date clieStartDate) {
		this.clieStartDate = clieStartDate;
	}

	public Date getClieEndDate() {
		return clieEndDate;
	}

	public void setClieEndDate(Date clieEndDate) {
		this.clieEndDate = clieEndDate;
	}	
	
	public String getClieEstado() {
		return clieEstado;
	}

	public void setClieEstado(String clieEstado) {
		this.clieEstado = clieEstado;
	}	

	public String getClieSharedKey() {
		return clieSharedKey;
	}

	public void setClieSharedKey(String clieSharedKey) {
		this.clieSharedKey = clieSharedKey;
	}	

	public String getCliePhone() {
		return cliePhone;
	}

	public void setCliePhone(String cliePhone) {
		this.cliePhone = cliePhone;
	}

	public Cliente toBO() {
		Cliente cliente = new Cliente();
		cliente.setClieEmail(clieEmail);
		cliente.setClieEndDate(clieEndDate);
		cliente.setClieId(clieId);
		cliente.setClieNombre(clieNombre);
		cliente.setClieStartDate(clieStartDate);
		cliente.setClieEstado(clieEstado);
		cliente.setClieSharedKey(clieSharedKey);
		cliente.setCliePhone(cliePhone);
		return cliente;
	}
}
