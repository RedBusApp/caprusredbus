package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BusAdminstrator")
public class BusAdminstrator implements Serializable{

	private static final long serialVersionUID = 5843397054361409993L;

	@Id
	private int adminId;
	
	private String password;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BusAdminstrator [adminId=" + adminId + ", password=" + password
				+ "]";
	}

}
