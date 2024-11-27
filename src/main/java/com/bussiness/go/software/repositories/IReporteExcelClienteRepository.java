package com.bussiness.go.software.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bussiness.go.software.entities.commons.ReporteExcelClienteModel;

@Repository
public interface IReporteExcelClienteRepository extends JpaRepository<ReporteExcelClienteModel, Long>{

	@Query(value ="SELECT row_number() OVER (ORDER BY c.clie_id) AS indice, c.clie_shared_key, c.clie_nombre, c.clie_email, c.clie_phone, \n"
			+ "to_char(c.clie_fecha,'DD/MM/YYYY') AS fecha FROM administracion.cliente as c WHERE c.clie_estado = :estado", nativeQuery = true)
	public List<ReporteExcelClienteModel> consultarClientes(String estado);
}
