package com.bussiness.go.software.entities.commons;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.bussiness.go.software.dto.ListaSelectorDTO;

@Entity
public class ListaSelector {

	private String label;
	@Id
	private String value;
	
	public ListaSelector() {
	}

	public ListaSelector(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public ListaSelectorDTO toBO() {
		ListaSelectorDTO  listaSelectorDTO = new ListaSelectorDTO();
		listaSelectorDTO.setLabel(label);
		listaSelectorDTO.setValue(value);
		return listaSelectorDTO;
	}
}
