package com.bussiness.go.software.services;

import java.util.UUID;

import com.bussiness.go.software.dto.CiudadDTO;
import com.bussiness.go.software.entities.commons.Ciudad;

public interface ICiudadService extends CommonService<Ciudad, UUID>{

	public CiudadDTO buscarInformacionCiudad(UUID ciudadId) throws RuntimeException;
}
