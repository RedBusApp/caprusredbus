package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fare")
public class Fare implements Serializable{
	
	private static final long serialVersionUID = 4612694481776138810L;

	@Id
	private int fareId;
	
	private short busTypeId;
	private int operatorid;
	private short amount;
	
	
	public int getFareId() {
		return fareId;
	}
	public void setFareId(int fareId) {
		this.fareId = fareId;
	}
	public short getBusTypeId() {
		return busTypeId;
	}
	public void setBusTypeId(short busTypeId) {
		this.busTypeId = busTypeId;
	}
	public int getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}
	public short getAmount() {
		return amount;
	}
	public void setAmount(short amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Fare [fareId=" + fareId + ", busTypeId=" + busTypeId
				+ ", operatorid=" + operatorid + ", amount=" + amount + "]";
	}
		

}
