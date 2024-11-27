package com.bussiness.go.software.entities.commons;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.bussiness.go.software.dto.DepartamentoDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the "departamento" database table.
 * 
 */
@Entity
@Table(name="departamento", schema="localizacion")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="depa_id")
	private UUID depaId;

	@Column(name="depa_estado")
	private String depaEstado;

	@Column(name="depa_fecha")
	private Timestamp depaFecha;

	@Column(name="depa_nombre")
	private String depaNombre;

	@Column(name="depa_update")
	private Timestamp depaUpdate;

	@Column(name="pais_id")
	private UUID paisId;

	public Departamento() {
	}

	public UUID getDepaId() {
		return this.depaId;
	}

	public void setDepaId(UUID depaId) {
		this.depaId = depaId;
	}

	public String getDepaEstado() {
		return this.depaEstado;
	}

	public void setDepaEstado(String depaEstado) {
		this.depaEstado = depaEstado;
	}

	public Timestamp getDepaFecha() {
		return this.depaFecha;
	}

	public void setDepaFecha(Timestamp depaFecha) {
		this.depaFecha = depaFecha;
	}

	public String getDepaNombre() {
		return this.depaNombre;
	}

	public void setDepaNombre(String depaNombre) {
		this.depaNombre = depaNombre;
	}

	public Timestamp getDepaUpdate() {
		return this.depaUpdate;
	}

	public void setDepaUpdate(Timestamp depaUpdate) {
		this.depaUpdate = depaUpdate;
	}

	public UUID getPaisId() {
		return this.paisId;
	}

	public void setPaisId(UUID paisId) {
		this.paisId = paisId;
	}

	public DepartamentoDTO toBO() {
		DepartamentoDTO departamentoDTO = new DepartamentoDTO();
		departamentoDTO.setDepaEstado(depaEstado);
		departamentoDTO.setDepaFecha(depaFecha);
		departamentoDTO.setDepaId(depaId);
		departamentoDTO.setDepaNombre(depaNombre);
		departamentoDTO.setDepaUpdate(depaUpdate);
		departamentoDTO.setPaisId(paisId);		
		return departamentoDTO;
	}
}