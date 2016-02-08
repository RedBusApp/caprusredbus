package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class BusStop implements Serializable{
	
	private static final long serialVersionUID = 6691536271659534591L;

	@Id
	private int busStopId;
	
	private String busStopName;

	public int getBusStopId() {
		return busStopId;
	}

	public void setBusStopId(int busStopId) {
		this.busStopId = busStopId;
	}

	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	
	@Override
	public String toString() {
		return "BusStop [busStopId=" + busStopId + ", busStopName="
				+ busStopName + "]";
	}
	
}
