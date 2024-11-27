package com.bussiness.go.software.entities.commons;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteExcelClienteModel implements Serializable{

	@Id
	private Long indice;
	private String clieSharedKey;
	private String clieNombre;	
	private String clieEmail;
	private String cliePhone;
	private String fecha;
	
	public ReporteExcelClienteModel() {
	}

	public ReporteExcelClienteModel(Long indice, String clieSharedKey, String clieNombre, String clieEmail,
			String cliePhone, String fecha) {
		this.indice = indice;
		this.clieSharedKey = clieSharedKey;
		this.clieNombre = clieNombre;
		this.clieEmail = clieEmail;
		this.cliePhone = cliePhone;
		this.fecha = fecha;
	}

	public Long getIndice() {
		return indice;
	}

	public void setIndice(Long indice) {
		this.indice = indice;
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
}
