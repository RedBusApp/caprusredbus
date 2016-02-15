package com.caprusit.redbus.domain;

import java.io.Serializable;

public class Bus_User_Utiltity implements Serializable {

	private static final long serialVersionUID = -8419444137597466828L;

	private int busId, numberOfSeats, busSerialNumber;
	private String busType, operatorName;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getBusSerialNumber() {
		return busSerialNumber;
	}

	public void setBusSerialNumber(int busSerialNumber) {
		this.busSerialNumber = busSerialNumber;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
