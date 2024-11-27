package com.bussiness.go.software.dto;

public class DataTablesRequest {

	Integer draw;
	Integer length;	
	DataTablesRequestSearch search;	
	Integer start;
	
	public DataTablesRequest() {
	}
	
	public DataTablesRequest(Integer draw, Integer length, DataTablesRequestSearch search, Integer start) {
		this.draw = draw;
		this.length = length;
		this.search = search;
		this.start = start;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public DataTablesRequestSearch getSearch() {
		return search;
	}

	public void setSearch(DataTablesRequestSearch search) {
		this.search = search;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}
