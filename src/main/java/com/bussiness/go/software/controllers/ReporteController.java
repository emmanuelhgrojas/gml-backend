package com.bussiness.go.software.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bussiness.go.software.entities.commons.ReporteExcelClienteModel;
import com.bussiness.go.software.reporte.ExcelGenerator;
import com.bussiness.go.software.services.IReporteExcelClienteService;
import com.bussiness.go.software.utilities.ApiResponse;
import com.bussiness.go.software.utilities.ConstantesApp;
import com.bussiness.go.software.utilities.MensajesApp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, maxAge = 3600)
@RequestMapping("/reportes")
public class ReporteController {

public static final Logger LOGGER = LoggerFactory.getLogger(ReporteController.class);
	
	@Autowired
	private IReporteExcelClienteService iReporteExcelClienteService;
	
	@GetMapping("/excel")
	public ApiResponse<String> exportIntoExcelFile(HttpServletResponse response) throws IOException, ParseException {
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=reporte-" + currentDateTime + ".xlsx";
        List<ReporteExcelClienteModel> listaClientes = iReporteExcelClienteService.consultarClientes(ConstantesApp.ESTADO_REGISTRO_ACTIVO);
        if(!listaClientes.isEmpty()) {
        	response.setContentType("application/octet-stream");
            response.setHeader(headerKey, headerValue);
        	ExcelGenerator generator = new ExcelGenerator(listaClientes);
            generator.generateExcelFile(response);
        }
        return new ApiResponse<>(HttpStatus.CONFLICT.value(), MensajesApp.REPORTE_EXCEL_EMPTY, null);
	 }
}
