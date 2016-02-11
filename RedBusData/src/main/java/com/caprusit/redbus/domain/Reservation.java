package com.caprusit.redbus.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 6694162676550857890L;
	
	public Reservation() {
		super();		
	}
	
	public Reservation(long reservationId) {
		super();
		this.reservationId = reservationId;
	}

	@Id
	private long reservationId;
	
	private long serialNumber;
	private long passengerId;
	private String source, destination;

	@Temporal(TemporalType.DATE)
	private Date journeyDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date journeyStartTime, journeyEndTime;

	private int amount, operatorId, busId;

	private short seatNumber;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Date getJourneyStartTime() {
		return journeyStartTime;
	}

	public void setJourneyStartTime(Date journeyStartTime) {
		this.journeyStartTime = journeyStartTime;
	}

	public Date getJourneyEndTime() {
		return journeyEndTime;
	}

	public void setJourneyEndTime(Date journeyEndTime) {
		this.journeyEndTime = journeyEndTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public short getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(short seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId
				+ ", serialNumber=" + serialNumber + ", passengerId="
				+ passengerId + ", source=" + source + ", destination="
				+ destination + ", journeyDate=" + journeyDate
				+ ", journeyStartTime=" + journeyStartTime
				+ ", journeyEndTime=" + journeyEndTime + ", amount=" + amount
				+ ", operatorId=" + operatorId + ", busId=" + busId
				+ ", seatNumber=" + seatNumber + "]";
	}

}
