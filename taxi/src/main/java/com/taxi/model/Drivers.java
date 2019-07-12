package com.taxi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="Drivers")  

public class Drivers {
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "GISX")
	private Double GISX;
	
	public Double getGISX() {
		return GISX;
	}
	public void setGISX(Double gISX) {
		GISX = gISX;
	}
	public Double getGISY() {
		return GISY;
	}
	public void setGISY(Double gISY) {
		GISY = gISY;
	}
	public Integer getStatus() {
		return status;
	}
	@Column(name = "GISY")
	private Double GISY;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
		
}
