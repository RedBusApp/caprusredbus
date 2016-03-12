package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BusDetails")
public class BusDetails implements Serializable{

	private static final long serialVersionUID = -2886542859879563143L;

	public BusDetails() {
		super();		
	}
	 
	public BusDetails(int busId) {
		super();
		this.busId = busId;
	}

	@Id
	private int busId;

	private int busSerialNumber,status;
	private String busName;
	
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="Bus_Type_Id_fk",nullable=false)
	private BusType busType;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="operarot_id_fk",nullable=false,unique=false)
	private Operator operator;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="route_id_fk",nullable=false,unique=false)
	private Route route;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBusSerialNumber() {
		return busSerialNumber;
	}

	public void setBusSerialNumber(int busSerialNumber) {
		this.busSerialNumber = busSerialNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
    

	
}
