package com.bussiness.go.software.entities.commons;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.bussiness.go.software.dto.PaisDTO;

import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the "pais" database table.
 * 
 */
@Entity
@Table(name="pais", schema="localizacion")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="pais_id")
	private UUID paisId;

	@Column(name="pais_estado")
	private String paisEstado;

	@Column(name="pais_fecha")
	private Timestamp paisFecha;

	@Column(name="pais_iso")
	private String paisIso;

	@Column(name="pais_nombre")
	private String paisNombre;

	@Column(name="pais_update")
	private Timestamp paisUpdate;


	public Pais() {
	}

	public UUID getPaisId() {
		return this.paisId;
	}

	public void setPaisId(UUID paisId) {
		this.paisId = paisId;
	}

	public String getPaisEstado() {
		return this.paisEstado;
	}

	public void setPaisEstado(String paisEstado) {
		this.paisEstado = paisEstado;
	}

	public Timestamp getPaisFecha() {
		return this.paisFecha;
	}

	public void setPaisFecha(Timestamp paisFecha) {
		this.paisFecha = paisFecha;
	}

	public String getPaisIso() {
		return this.paisIso;
	}

	public void setPaisIso(String paisIso) {
		this.paisIso = paisIso;
	}

	public String getPaisNombre() {
		return this.paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}

	public Timestamp getPaisUpdate() {
		return this.paisUpdate;
	}

	public void setPaisUpdate(Timestamp paisUpdate) {
		this.paisUpdate = paisUpdate;
	}

	public PaisDTO toBO() {
		PaisDTO paisDTO = new PaisDTO();
		paisDTO.setPaisEstado(paisEstado);
		paisDTO.setPaisFecha(paisFecha);
		paisDTO.setPaisId(paisId);
		paisDTO.setPaisIso(paisIso);
		paisDTO.setPaisNombre(paisNombre);
		paisDTO.setPaisUpdate(paisUpdate);
		return paisDTO;		
	}
}