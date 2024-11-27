package com.bussiness.go.software.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.bussiness.go.software.entities.commons.Pais;

public class PaisDTO {

	private UUID paisId;
	private String paisEstado;
	private Timestamp paisFecha;
	private String paisIso;
	private String paisNombre;
	private Timestamp paisUpdate;
	
	public PaisDTO() {
	}

	public PaisDTO(UUID paisId, String paisEstado, Timestamp paisFecha, String paisIso, String paisNombre,
			Timestamp paisUpdate) {
		this.paisId = paisId;
		this.paisEstado = paisEstado;
		this.paisFecha = paisFecha;
		this.paisIso = paisIso;
		this.paisNombre = paisNombre;
		this.paisUpdate = paisUpdate;
	}

	public UUID getPaisId() {
		return paisId;
	}

	public void setPaisId(UUID paisId) {
		this.paisId = paisId;
	}

	public String getPaisEstado() {
		return paisEstado;
	}

	public void setPaisEstado(String paisEstado) {
		this.paisEstado = paisEstado;
	}

	public Timestamp getPaisFecha() {
		return paisFecha;
	}

	public void setPaisFecha(Timestamp paisFecha) {
		this.paisFecha = paisFecha;
	}

	public String getPaisIso() {
		return paisIso;
	}

	public void setPaisIso(String paisIso) {
		this.paisIso = paisIso;
	}

	public String getPaisNombre() {
		return paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}

	public Timestamp getPaisUpdate() {
		return paisUpdate;
	}

	public void setPaisUpdate(Timestamp paisUpdate) {
		this.paisUpdate = paisUpdate;
	}
	
	public Pais toBO() {
		Pais pais = new Pais();
		pais.setPaisEstado(paisEstado);
		pais.setPaisFecha(paisFecha);
		pais.setPaisId(paisId);
		pais.setPaisIso(paisIso);
		pais.setPaisNombre(paisNombre);
		pais.setPaisUpdate(paisUpdate);
		return pais;		
	}
}
