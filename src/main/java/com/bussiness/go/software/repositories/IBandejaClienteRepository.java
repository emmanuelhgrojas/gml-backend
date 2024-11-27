package com.bussiness.go.software.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.BandejaClienteModel;

@Repository
public interface IBandejaClienteRepository extends JpaRepository<BandejaClienteModel, UUID>{

	@Query(value ="SELECT clie_id, c.clie_shared_key, c.clie_nombre, c.clie_email, c.clie_phone, to_char(c.clie_fecha,'DD/MM/YYYY') AS fecha FROM administracion.cliente as c \n"
			+ "WHERE (c.clie_estado = :estado) AND \n"
			+ "(c.clie_shared_key LIKE %:filtro% OR c.clie_nombre LIKE %:filtro% OR c.clie_email LIKE %:filtro% OR c.clie_phone LIKE %:filtro% OR to_char(c.clie_fecha,'DD/MM/YYYY') LIKE %:filtro%)\n"
			+ "limit :limitQuery offset :offsetQuery", nativeQuery = true)
	public List<BandejaClienteModel> listaClientesPorEstadoConFiltro(String filtro, String estado, Integer limitQuery, Integer offsetQuery);
	
	@Query(value ="SELECT clie_id, c.clie_shared_key, c.clie_nombre, c.clie_email, c.clie_phone, to_char(c.clie_fecha,'DD/MM/YYYY') AS fecha FROM administracion.cliente as c \n"
			+ "WHERE c.clie_estado = :estado\n"			
			+ "limit :limitQuery offset :offsetQuery", nativeQuery = true)
	public List<BandejaClienteModel> listaClientesPorEstadoSinFiltro(String estado, Integer limitQuery, Integer offsetQuery);
	
	@Query(value ="SELECT clie_id, c.clie_shared_key, c.clie_nombre, c.clie_email, c.clie_phone, to_char(c.clie_fecha,'DD/MM/YYYY') AS fecha FROM administracion.cliente as c \n"			
			+ "WHERE c.clie_estado = :estado\n", nativeQuery = true)
	public List<BandejaClienteModel> totalListaClientesPorEstado(String estado);
}
