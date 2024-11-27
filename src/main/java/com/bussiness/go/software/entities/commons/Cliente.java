package com.bussiness.go.software.entities.commons;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.bussiness.go.software.dto.ClienteDTO;

/**
 * The persistent class for the "cliente" database table.
 * 
 */
@Entity
@Table(name="cliente", schema="administracion")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="clie_id")
	private UUID clieId;

	@Column(name="clie_nombre")
	private String clieNombre;
	
	@Column(name="clie_email")
	private String clieEmail;

	@Column(name="clie_start_date")
	private Date clieStartDate;
	
	@Column(name="clie_end_date")
	private Date clieEndDate;
	
	@Column(name="clie_estado")
	private String clieEstado;
	
	@Column(name="clie_shared_key")
	private String clieSharedKey;
	
	@Column(name="clie_phone")
	private String cliePhone;
	

	public Cliente() {
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

	public ClienteDTO toBO() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setClieEmail(clieEmail);
		clienteDTO.setClieEndDate(clieEndDate);
		clienteDTO.setClieId(clieId);
		clienteDTO.setClieNombre(clieNombre);
		clienteDTO.setClieStartDate(clieStartDate);	
		clienteDTO.setClieEstado(clieEstado);
		clienteDTO.setClieSharedKey(clieSharedKey);
		clienteDTO.setCliePhone(cliePhone);
		return clienteDTO;
	}
}
