package com.bussiness.go.software.entities.commons;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.bussiness.go.software.dto.UsuarioDTO;

import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the "usuario" database table.
 * 
 */
@Entity
@Table(name="usuario", schema="administracion")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="usua_id")
	private UUID usuaId;

	@Column(name="usua_email")
	private String usuaEmail;

	@Column(name="usua_estado")
	private String usuaEstado;

	@Column(name="usua_fecha")
	private Date usuaFecha;

	@Column(name="usua_password")
	private String usuaPassword;

	@Column(name="usua_username")
	private String usuaUsername;
	
	@Column(name="usua_nombres")
	private String usuaNombres;
	
	@Column(name="usua_apellidos")
	private String usuaApellidos;


	public Usuario() {
	}

	public UUID getUsuaId() {
		return this.usuaId;
	}

	public void setUsuaId(UUID usuaId) {
		this.usuaId = usuaId;
	}

	public String getUsuaEmail() {
		return this.usuaEmail;
	}

	public void setUsuaEmail(String usuaEmail) {
		this.usuaEmail = usuaEmail;
	}

	public String getUsuaEstado() {
		return this.usuaEstado;
	}

	public void setUsuaEstado(String usuaEstado) {
		this.usuaEstado = usuaEstado;
	}

	public Date getUsuaFecha() {
		return this.usuaFecha;
	}

	public void setUsuaFecha(Date usuaFecha) {
		this.usuaFecha = usuaFecha;
	}

	public String getUsuaPassword() {
		return this.usuaPassword;
	}

	public void setUsuaPassword(String usuaPassword) {
		this.usuaPassword = usuaPassword;
	}

	public String getUsuaUsername() {
		return this.usuaUsername;
	}

	public void setUsuaUsername(String usuaUsername) {
		this.usuaUsername = usuaUsername;
	}

	public String getUsuaNombres() {
		return usuaNombres;
	}

	public void setUsuaNombres(String usuaNombres) {
		this.usuaNombres = usuaNombres;
	}

	public String getUsuaApellidos() {
		return usuaApellidos;
	}

	public void setUsuaApellidos(String usuaApellidos) {
		this.usuaApellidos = usuaApellidos;
	}

	public UsuarioDTO toBO() {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setUsuaEmail(usuaEmail);
		usuarioDTO.setUsuaEstado(usuaEstado);
		usuarioDTO.setUsuaFecha(usuaFecha);
		usuarioDTO.setUsuaId(usuaId);
		usuarioDTO.setUsuaPassword(usuaPassword);
		usuarioDTO.setUsuaUsername(usuaUsername);
		usuarioDTO.setUsuaNombres(usuaNombres);
		usuarioDTO.setUsuaApellidos(usuaApellidos);
		return usuarioDTO;
	}
}