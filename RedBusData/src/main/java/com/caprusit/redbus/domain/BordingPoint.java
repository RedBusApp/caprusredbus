package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BordingPoint")
public class BordingPoint implements Serializable {

	private static final long serialVersionUID = -128676550950050177L;
	
	public BordingPoint() {
		
	}
	
	public BordingPoint(int boardingPointId) {
		super();
		this.boardingPointId = boardingPointId;
	}

	@Id
	private int boardingPointId;
	
	private String boardingPointName;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BordingPoint [boardingPointId=" + boardingPointId
				+ ", boardingPointName=" + boardingPointName + "]";
	}
	

}
