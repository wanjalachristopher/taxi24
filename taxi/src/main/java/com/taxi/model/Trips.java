package com.taxi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="Trips")
public class Trips {
	
	@Id
	@Column(name = "ID")
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "TRIPSTART")
	private Date dateStart;
	
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	@Column(name = "TRIPEND")
	private Date dateEnd;
	
	
	@Column(name = "DRIVERID")
	private Long driverId;
	
	@Column(name = "RIDERID")
	private Long riderId;
	
	@Column(name = "STATUS")
	private int status;
	
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public Long getRiderId() {
		return riderId;
	}
	public void setRiderId(Long riderId) {
		this.riderId = riderId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
