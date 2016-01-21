package com.egen.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TableDetails {
	private static final long serialVersionUID = -549896870397622366L;
	@Id
	private Integer tableId;
	private Integer capacity;
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer id) {
		this.tableId = id;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public TableDetails(){
		
	}
	public TableDetails(Integer id, Integer capacity) {
		super();
		this.tableId = id;
		this.capacity = capacity;
	}
	
	
}
