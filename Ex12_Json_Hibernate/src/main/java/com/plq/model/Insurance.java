package com.plq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSURANCE")
public class Insurance {
	
	@Id
	@Column(name="NAMEINSURANCE")
	private String name;
	@Column(name="TYPEINSURANCE")
	private String type;
	
	public Insurance(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
