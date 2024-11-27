package com.bussiness.go.software.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.bussiness.go.software.entities.commons.Departamento;

public class DepartamentoDTO {

	private UUID depaId;
	private String depaEstado;
	private Timestamp depaFecha;
	private String depaNombre;
	private Timestamp depaUpdate;
	private UUID paisId;
	
	public DepartamentoDTO() {
	}

	public DepartamentoDTO(UUID depaId, String depaEstado, Timestamp depaFecha, String depaNombre, Timestamp depaUpdate,
			UUID paisId) {
		this.depaId = depaId;
		this.depaEstado = depaEstado;
		this.depaFecha = depaFecha;
		this.depaNombre = depaNombre;
		this.depaUpdate = depaUpdate;
		this.paisId = paisId;
	}

	public UUID getDepaId() {
		return depaId;
	}

	public void setDepaId(UUID depaId) {
		this.depaId = depaId;
	}

	public String getDepaEstado() {
		return depaEstado;
	}

	public void setDepaEstado(String depaEstado) {
		this.depaEstado = depaEstado;
	}

	public Timestamp getDepaFecha() {
		return depaFecha;
	}

	public void setDepaFecha(Timestamp depaFecha) {
		this.depaFecha = depaFecha;
	}

	public String getDepaNombre() {
		return depaNombre;
	}

	public void setDepaNombre(String depaNombre) {
		this.depaNombre = depaNombre;
	}

	public Timestamp getDepaUpdate() {
		return depaUpdate;
	}

	public void setDepaUpdate(Timestamp depaUpdate) {
		this.depaUpdate = depaUpdate;
	}

	public UUID getPaisId() {
		return paisId;
	}

	public void setPaisId(UUID paisId) {
		this.paisId = paisId;
	}
	
	public Departamento toBO() {
		Departamento departamento = new Departamento();
		departamento.setDepaEstado(depaEstado);
		departamento.setDepaFecha(depaFecha);
		departamento.setDepaId(depaId);
		departamento.setDepaNombre(depaNombre);
		departamento.setDepaUpdate(depaUpdate);
		departamento.setPaisId(paisId);		
		return departamento;
	}
}
