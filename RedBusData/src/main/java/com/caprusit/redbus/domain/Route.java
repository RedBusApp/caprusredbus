package com.caprusit.redbus.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Route")
public class Route implements Serializable {

	private static final long serialVersionUID = 5825249753387850999L;

	public Route() {
		super();
		
	}
	
	public Route(int routeId) {
		super();
		this.routeId = routeId;
	}

	@Id
	private int routeId;

	private String source, destination;

	private int distance;

	@ManyToMany()
	@Fetch(FetchMode.SUBSELECT)
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name = "BusStop_Route_Table", joinColumns = { @JoinColumn(name = "Route_Id_fk",unique=false, nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "BusStop_Id_fk",unique=false, nullable = false) })
	private Set<BusStop> SetOfbusStops;

	@ManyToMany()
	@Fetch(FetchMode.SUBSELECT)
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name = "Route_opearator_Table", joinColumns = { @JoinColumn(name = "Route_Id_FK",unique=false, nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "operator_id_fk",unique=false, nullable = false) })
	private Set<Operator> setOfOperators;
	
	@OneToMany()
	@Fetch(FetchMode.SUBSELECT) //
	@JoinColumn(name="Route_Id_fk")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set<BusDetails> setOfBusses;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Set<BusStop> getSetOfbusStops() {
		return SetOfbusStops;
	}

	public void setSetOfbusStops(Set<BusStop> setOfbusStops) {
		SetOfbusStops = setOfbusStops;
	}

	public Set<Operator> getSetOfOperators() {
		return setOfOperators;
	}

	public void setSetOfOperators(Set<Operator> setOfOperators) {
		this.setOfOperators = setOfOperators;
	}

	public Set<BusDetails> getSetOfBusses() {
		return setOfBusses;
	}

	public void setSetOfBusses(Set<BusDetails> setOfBusses) {
		this.setOfBusses = setOfBusses;
	}

	
	
}
