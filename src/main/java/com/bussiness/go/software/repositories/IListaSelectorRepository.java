package com.bussiness.go.software.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.ListaSelector;


@Repository
public interface IListaSelectorRepository extends JpaRepository<ListaSelector, String>{
	
	@Query(value ="SELECT tiid_prefijo || ' - ' || ti.tiid_nombre label, ti.tiid_id value FROM general.tipo_identificacion ti WHERE ti.tiid_estado = 'AC' ORDER BY ti.tiid_nombre ASC", nativeQuery = true)
	public List<ListaSelector> consultarListaTipoIdentificacion();
	
	@Query(value ="SELECT pa.pais_nombre label, pa.pais_id value FROM localizacion.pais pa WHERE pa.pais_estado = 'AC' ORDER BY pa.pais_nombre ASC", nativeQuery = true)
	public List<ListaSelector> consultarListaPais();
	
	@Query(value ="SELECT de.depa_nombre label, de.depa_id value FROM localizacion.departamento de \n"
			+ "INNER JOIN localizacion.pais pa ON pa.pais_id = de.pais_id\n"
			+ "WHERE de.depa_estado = 'AC' AND pa.pais_estado = 'AC' AND pa.pais_id = :paisId  ORDER BY de.depa_nombre ASC", nativeQuery = true)
	public List<ListaSelector> consultarListaDepartamentoPais(UUID paisId);
	
	@Query(value ="SELECT ci.ciud_nombre label, ci.ciud_id value FROM localizacion.ciudad ci \n"
			+ "INNER JOIN localizacion.departamento de ON de.depa_id = ci.depa_id\n"
			+ "WHERE ci.ciud_estado = 'AC' AND de.depa_estado = 'AC' AND ci.depa_id = :depaId ORDER BY ci.ciud_nombre ASC", nativeQuery = true)
	public List<ListaSelector> consultarListaCiudadDepartamento(UUID depaId);
}
