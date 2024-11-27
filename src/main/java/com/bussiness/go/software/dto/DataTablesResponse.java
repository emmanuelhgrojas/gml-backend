package com.bussiness.go.software.dto;

import java.util.List;

public class DataTablesResponse<T> {
	List<T> data;
	Integer draw;
	Integer recordsFiltered;
	Integer recordsTotal;
	
	public DataTablesResponse() {
	}
	public DataTablesResponse(List<T> data, Integer draw, Integer recordsFiltered, Integer recordsTotal) {
		super();
		this.data = data;
		this.draw = draw;
		this.recordsFiltered = recordsFiltered;
		this.recordsTotal = recordsTotal;
	}
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
}
