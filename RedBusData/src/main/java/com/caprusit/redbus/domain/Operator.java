package com.caprusit.redbus.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Operator")
public class Operator implements Serializable {

	private static final long serialVersionUID = 3894628453038234012L;

	public Operator() {
		super();		
	}
	
	public Operator(int operatorId) {
		super();
		this.operatorId = operatorId;
	}

	@Id
	private int operatorId;

	private String operatorName;
	private String operatorPassword;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@Fetch(FetchMode.SUBSELECT) // join
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name="Route_opearator_Table",joinColumns={@JoinColumn(name="operator_id_fk",unique=false,nullable=false)},inverseJoinColumns={@JoinColumn(name="Route_Id_FK",unique=false,nullable=false)})
	private Set<Route> setOfRoutes;

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}

	public Set<Route> getSetOfRoutes() {
		return setOfRoutes;
	}

	public void setSetOfRoutes(Set<Route> setOfRoutes) {
		this.setOfRoutes = setOfRoutes;
	}

	@Override
	public String toString() {
		return "Operator [operatorId=" + operatorId + ", operatorName="
				+ operatorName + ", operatorPassword=" + operatorPassword
				+ ", setOfRoutes=" + setOfRoutes + "]";
	}
	
	

}
