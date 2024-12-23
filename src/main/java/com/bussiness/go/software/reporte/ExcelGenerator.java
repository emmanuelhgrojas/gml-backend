package com.bussiness.go.software.reporte;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bussiness.go.software.entities.commons.ReporteExcelClienteModel;

public class ExcelGenerator {

	private List<ReporteExcelClienteModel> listaClientes;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List<ReporteExcelClienteModel> listaClientes) {
        this.listaClientes = listaClientes;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeader() {
        sheet = workbook.createSheet("clientes");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "SHARED KEY", style);
        createCell(row, 2, "NOMBRE", style);
        createCell(row, 3, "EMAIL", style);
        createCell(row, 4, "TELEFONO", style);
        createCell(row, 5, "FECHA", style);
    }
    
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        
        if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        }else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (ReporteExcelClienteModel record: listaClientes) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getIndice(), style);
            createCell(row, columnCount++, record.getClieSharedKey(), style);
            createCell(row, columnCount++, record.getClieNombre(), style);
            createCell(row, columnCount++, record.getClieEmail(), style);
            createCell(row, columnCount++, record.getCliePhone(), style);
            createCell(row, columnCount++, record.getFecha(), style);
        }
    }
    
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
