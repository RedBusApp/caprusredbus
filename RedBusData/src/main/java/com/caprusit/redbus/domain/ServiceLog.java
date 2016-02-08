package com.caprusit.redbus.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ServiceLog")
public class ServiceLog implements Serializable {

	private static final long serialVersionUID = -1366352952294686961L;

	@Id
	private long serviceLogId;
	private int operatorId;

	@Temporal(TemporalType.DATE)
	private Date serviceStartDate, serviceEndDate;

	private int routeId;

	public long getServiceLogId() {
		return serviceLogId;
	}

	public void setServiceLogId(long serviceLogId) {
		this.serviceLogId = serviceLogId;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ServiceLog [serviceLogId=" + serviceLogId + ", operatorId="
				+ operatorId + ", serviceStartDate=" + serviceStartDate
				+ ", serviceEndDate=" + serviceEndDate + ", routeId=" + routeId
				+ "]";
	}

}
