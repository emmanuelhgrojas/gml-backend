package com.bussiness.go.software.security;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class AuthAuthenticateDTO {
	
	private UUID usuaId;
	private String usuaEmail;
	private String usuaEstado;	
	private Date usuaFecha;
	private String usuaUsername; 
	private String jwtToken;
	private String rolNombre;
	private UUID rolId;
}
