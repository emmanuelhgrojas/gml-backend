package com.bussiness.go.software.entities.commons;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.bussiness.go.software.dto.CiudadDTO;

import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the "ciudad" database table.
 * 
 */
@Entity
@Table(name="ciudad", schema="localizacion")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="ciud_id", columnDefinition = "uuid")
	private UUID ciudId;

	@Column(name="ciud_estado")
	private String ciudEstado;

	@Column(name="ciud_fecha")
	private Timestamp ciudFecha;

	@Column(name="ciud_nombre")
	private String ciudNombre;

	@Column(name="ciud_update")
	private Timestamp ciudUpdate;

	@Column(name="depa_id")
	private UUID depaId;

	public Ciudad() {
	}

	public UUID getCiudId() {
		return this.ciudId;
	}

	public void setCiudId(UUID ciudId) {
		this.ciudId = ciudId;
	}

	public String getCiudEstado() {
		return this.ciudEstado;
	}

	public void setCiudEstado(String ciudEstado) {
		this.ciudEstado = ciudEstado;
	}

	public Timestamp getCiudFecha() {
		return this.ciudFecha;
	}

	public void setCiudFecha(Timestamp ciudFecha) {
		this.ciudFecha = ciudFecha;
	}

	public String getCiudNombre() {
		return this.ciudNombre;
	}

	public void setCiudNombre(String ciudNombre) {
		this.ciudNombre = ciudNombre;
	}

	public Timestamp getCiudUpdate() {
		return this.ciudUpdate;
	}

	public void setCiudUpdate(Timestamp ciudUpdate) {
		this.ciudUpdate = ciudUpdate;
	}

	public UUID getDepaId() {
		return this.depaId;
	}

	public void setDepaId(UUID depaId) {
		this.depaId = depaId;
	}

	public CiudadDTO toBO() {
		CiudadDTO ciudadDTO = new CiudadDTO();
		ciudadDTO.setCiudEstado(ciudEstado);
		ciudadDTO.setCiudFecha(ciudFecha);
		ciudadDTO.setCiudId(ciudId);
		ciudadDTO.setCiudNombre(ciudNombre);
		ciudadDTO.setCiudUpdate(ciudUpdate);
		ciudadDTO.setDepaId(depaId);
		return ciudadDTO;
	}
}