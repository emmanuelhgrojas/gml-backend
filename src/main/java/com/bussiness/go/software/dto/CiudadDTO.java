package com.bussiness.go.software.dto;

import java.sql.Timestamp;
import java.util.UUID;

import com.bussiness.go.software.entities.commons.Ciudad;

public class CiudadDTO {

	private UUID ciudId;
	private String ciudEstado;
	private Timestamp ciudFecha;
	private String ciudNombre;
	private Timestamp ciudUpdate;
	private UUID depaId;
	private UUID paisId;
	
	public CiudadDTO() {
	}	

	public CiudadDTO(UUID ciudId, String ciudEstado, Timestamp ciudFecha, String ciudNombre, Timestamp ciudUpdate,
			UUID depaId, UUID paisId) {
		super();
		this.ciudId = ciudId;
		this.ciudEstado = ciudEstado;
		this.ciudFecha = ciudFecha;
		this.ciudNombre = ciudNombre;
		this.ciudUpdate = ciudUpdate;
		this.depaId = depaId;
		this.paisId = paisId;
	}

	public UUID getCiudId() {
		return ciudId;
	}

	public void setCiudId(UUID ciudId) {
		this.ciudId = ciudId;
	}

	public String getCiudEstado() {
		return ciudEstado;
	}

	public void setCiudEstado(String ciudEstado) {
		this.ciudEstado = ciudEstado;
	}

	public Timestamp getCiudFecha() {
		return ciudFecha;
	}

	public void setCiudFecha(Timestamp ciudFecha) {
		this.ciudFecha = ciudFecha;
	}

	public String getCiudNombre() {
		return ciudNombre;
	}

	public void setCiudNombre(String ciudNombre) {
		this.ciudNombre = ciudNombre;
	}

	public Timestamp getCiudUpdate() {
		return ciudUpdate;
	}

	public void setCiudUpdate(Timestamp ciudUpdate) {
		this.ciudUpdate = ciudUpdate;
	}

	public UUID getDepaId() {
		return depaId;
	}

	public void setDepaId(UUID depaId) {
		this.depaId = depaId;
	}

	public UUID getPaisId() {
		return paisId;
	}

	public void setPaisId(UUID paisId) {
		this.paisId = paisId;
	}	
	
	public Ciudad toBO() {
		Ciudad ciudad = new Ciudad();
		ciudad.setCiudEstado(ciudEstado);
		ciudad.setCiudFecha(ciudFecha);
		ciudad.setCiudId(ciudId);
		ciudad.setCiudNombre(ciudNombre);
		ciudad.setCiudUpdate(ciudUpdate);
		ciudad.setDepaId(depaId);
		return ciudad;
	}
}
