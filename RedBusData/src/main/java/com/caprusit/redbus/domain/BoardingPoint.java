package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "BoardingPoint")
public class BoardingPoint implements Serializable {

	private static final long serialVersionUID = -128676550950050177L;

	public BoardingPoint() {

	}

	public BoardingPoint(int boardingPointId) {
		super();
		this.boardingPointId = boardingPointId;
	}

	@Id
	private int boardingPointId;

	private String boardingPointName, boardingPointAddress;

	@ManyToOne()
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "busStopId_fk")
	private BusStop busStop;

	public int getBoardingPointId() {
		return boardingPointId;
	}

	public void setBoardingPointId(int boardingPointId) {
		this.boardingPointId = boardingPointId;
	}

	public String getBoardingPointName() {
		return boardingPointName;
	}

	public void setBoardingPointName(String boardingPointName) {
		this.boardingPointName = boardingPointName;
	}

	public BusStop getBusStop() {
		return busStop;
	}

	public void setBusStop(BusStop busStop) {
		this.busStop = busStop;
	}

	public String getBoardingPointAddress() {
		return boardingPointAddress;
	}

	public void setBoardingPointAddress(String boardingPointAddress) {
		this.boardingPointAddress = boardingPointAddress;
	}

}
