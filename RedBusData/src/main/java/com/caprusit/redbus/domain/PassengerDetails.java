package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PassengerDetails")
public class PassengerDetails  implements Serializable{
	
	private static final long serialVersionUID = -3922696473060189130L;
	
	public PassengerDetails() {
		super();		
	}
	
	public PassengerDetails(long passengerId) {
		super();
		this.passengerId = passengerId;
	}

	@Id
	private long passengerId;
	
	private String passengerName;
	private String gender;
	private byte age;
	private int mobileNumber;
	private String emailId, address;
	private String password;

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerId=" + passengerId
				+ ", passengerName=" + passengerName + ", gender=" + gender
				+ ", age=" + age + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", address=" + address
				+ ", password=" + password + "]";
	}

}
