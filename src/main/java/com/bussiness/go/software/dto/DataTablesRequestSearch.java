package com.bussiness.go.software.dto;

public class DataTablesRequestSearch {
	
	Boolean regex;
	String value;
	
	public DataTablesRequestSearch() {
	}

	public DataTablesRequestSearch(Boolean regex, String value) {
		this.regex = regex;
		this.value = value;
	}

	public Boolean getRegex() {
		return regex;
	}

	public void setRegex(Boolean regex) {
		this.regex = regex;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
