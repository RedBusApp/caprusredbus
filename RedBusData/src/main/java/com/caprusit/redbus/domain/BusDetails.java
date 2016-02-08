package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BusDetails")
public class BusDetails implements Serializable{

	private static final long serialVersionUID = -2886542859879563143L;

	@Id
	private int busId;

	private int busSerialNumber;
	private String busName;
	private short busTypeId;
	private int routeId, operatorId;

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

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public short getBusTypeId() {
		return busTypeId;
	}

	public void setBusTypeId(short busTypeId) {
		this.busTypeId = busTypeId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	@Override
	public String toString() {
		return "BusDetails [busId=" + busId + ", busSerialNumber="
				+ busSerialNumber + ", busName=" + busName + ", busTypeId="
				+ busTypeId + ", routeId=" + routeId + ", operatorId="
				+ operatorId + "]";
	}

}
