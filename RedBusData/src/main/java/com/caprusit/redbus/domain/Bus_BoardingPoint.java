package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bus_BoardingPoint")
public class Bus_BoardingPoint implements Serializable {

	private static final long serialVersionUID = -3102298511659729159L;

	@Id
	private int bus_boardingPoint_id;

	private int busId;

	private int boardingPOintId;

	public int getBus_boardingPoint_id() {
		return bus_boardingPoint_id;
	}

	public void setBus_boardingPoint_id(int bus_boardingPoint_id) {
		this.bus_boardingPoint_id = bus_boardingPoint_id;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBoardingPOintId() {
		return boardingPOintId;
	}

	public void setBoardingPOintId(int boardingPOintId) {
		this.boardingPOintId = boardingPOintId;
	}

	@Override
	public String toString() {
		return "Bus_BoardingPoint [bus_boardingPoint_id="
				+ bus_boardingPoint_id + ", busId=" + busId
				+ ", boardingPOintId=" + boardingPOintId + "]";
	}

}
