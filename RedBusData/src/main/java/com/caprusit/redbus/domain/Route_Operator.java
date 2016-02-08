package com.caprusit.redbus.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Route_Operator")
public class Route_Operator implements Serializable {

	private static final long serialVersionUID = 7094615688605346941L;

	@Id
	private short route_operator_id;

	private int routeId;
	private int operatorId;
	

	public short getRoute_operator_id() {
		return route_operator_id;
	}

	public void setRoute_operator_id(short route_operator_id) {
		this.route_operator_id = route_operator_id;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	@Override
	public String toString() {
		return "Route_Operator [route_operator_id=" + route_operator_id
				+ ", routeId=" + routeId + ", operatorId=" + operatorId + "]";
	}

}
