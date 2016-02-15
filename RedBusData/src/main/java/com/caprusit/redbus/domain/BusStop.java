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
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="")
public class BusStop implements Serializable{
	
	private static final long serialVersionUID = 6691536271659534591L;

	public BusStop() {
		super();
		
	}
	
	public BusStop(int busStopId) {
		super();
		this.busStopId = busStopId;
	}

	@Id
	private int busStopId;
	
	private String busStopName;

	@ManyToMany()
	@Cascade(CascadeType.PERSIST)
	@Fetch(FetchMode.SUBSELECT) //FetchMode.JOIN
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name="BusStop_Route_Table",joinColumns={@JoinColumn(name="BusStop_Id_fk",unique=false,nullable=false)},inverseJoinColumns={@JoinColumn(name="Route_Id_fk",unique=false,nullable=false)})
	private Set<Route> setOfRoutes;
	
	@OneToMany()
	@Cascade(CascadeType.PERSIST)
	@Fetch(FetchMode.SUBSELECT) // JOIN
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinColumn(name="busStopId_fk")
	private Set<BoardingPoint> setOfBoardingPoints;

	public int getBusStopId() {
		return busStopId;
	}

	public void setBusStopId(int busStopId) {
		this.busStopId = busStopId;
	}

	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public Set<Route> getSetOfRoutes() {
		return setOfRoutes;
	}

	public void setSetOfRoutes(Set<Route> setOfRoutes) {
		this.setOfRoutes = setOfRoutes;
	}

	public Set<BoardingPoint> getSetOfBoardingPoints() {
		return setOfBoardingPoints;
	}

	public void setSetOfBoardingPoints(Set<BoardingPoint> setOfBoardingPoints) {
		this.setOfBoardingPoints = setOfBoardingPoints;
	}

	
}
