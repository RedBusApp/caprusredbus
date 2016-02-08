package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BusType_table")
public class BusType implements Serializable {

	private static final long serialVersionUID = -600245986737819685L;

	@Id
	@GenericGenerator(name = "increment", strategy = "increment")
	@GeneratedValue(generator = "increment")
	private short busTypeId;

	private String busTypeName;
	private short numberOfSeats;

	public short getBusTypeId() {
		return busTypeId;
	}

	public void setBusTypeId(short busTypeId) {
		this.busTypeId = busTypeId;
	}

	public String getBusTypeName() {
		return busTypeName;
	}

	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}

	public short getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(short numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "BusType [busTypeId=" + busTypeId + ", busTypeName="
				+ busTypeName + ", numberOfSeats=" + numberOfSeats + "]";
	}
	
	

}
