package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BusDetails_BusStop")
public class BusDetails_BusStop implements Serializable {

	private static final long serialVersionUID = 210276501082718168L;

	@Id
	private int busDetails_busStop_id;

	private int busId, busStopId;

	public int getBusDetails_busStop_id() {
		return busDetails_busStop_id;
	}

	public void setBusDetails_busStop_id(int busDetails_busStop_id) {
		this.busDetails_busStop_id = busDetails_busStop_id;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBusStopId() {
		return busStopId;
	}

	public void setBusStopId(int busStopId) {
		this.busStopId = busStopId;
	}

	@Override
	public String toString() {
		return "BusDetails_BusStop [busDetails_busStop_id="
				+ busDetails_busStop_id + ", busId=" + busId + ", busStopId="
				+ busStopId + "]";
	}

}
