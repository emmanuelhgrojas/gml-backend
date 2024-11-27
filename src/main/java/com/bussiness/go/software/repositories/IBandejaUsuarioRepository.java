package com.bussiness.go.software.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.BandejaUsuarioModel;

@Repository
public interface IBandejaUsuarioRepository extends JpaRepository<BandejaUsuarioModel, UUID>{

	@Query(value ="SELECT u.usua_id, u.usua_email, u.usua_username FROM administracion.usuario as u \n"
			+ "WHERE (u.usua_estado = :estado) AND \n"
			+ "(u.usua_email LIKE %:filtro% OR u.usua_username LIKE %:filtro%)\n"
			+ "limit :limitQuery offset :offsetQuery", nativeQuery = true)
	public List<BandejaUsuarioModel> listaUsuariosPorEstadoConFiltro(String filtro, String estado, Integer limitQuery, Integer offsetQuery);
	
	@Query(value ="SELECT u.usua_id, u.usua_email, u.usua_username FROM administracion.usuario as u \n"
			+ "WHERE u.usua_estado = :estado\n"			
			+ "limit :limitQuery offset :offsetQuery", nativeQuery = true)
	public List<BandejaUsuarioModel> listaUsuariosPorEstadoSinFiltro(String estado, Integer limitQuery, Integer offsetQuery);
	
	@Query(value ="SELECT u.usua_id, u.usua_email, u.usua_username FROM administracion.usuario as u \n"			
			+ "WHERE u.usua_estado = :estado\n", nativeQuery = true)
	public List<BandejaUsuarioModel> totalListaUsuariosPorEstado(String estado);
}