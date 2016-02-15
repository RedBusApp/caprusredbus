package com.caprusit.redbus.data.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.ManageRoute_Data;
import com.caprusit.redbus.data.utility.CurdOperationUtility;
import com.caprusit.redbus.domain.BusStop;
import com.caprusit.redbus.domain.Operator;
import com.caprusit.redbus.domain.Route;

@Repository
public class ManageRoute_DataImpl implements ManageRoute_Data{

	@Autowired
	private CurdOperationUtility curdOperationUtility;
	
	private Logger logger=Logger.getLogger(ManageRoute_DataImpl.class);
	
	/**
	 * This method is to save Route class object into database
	 * 
	 * @param Route Route class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	public int saveRoute(Route route) {
				
		return (Integer)curdOperationUtility.saveObjectToDatabase(route);
	}

	/**
	 * This method is to update Route class object in database
	 * 
	 * @param Route Route class object to save into database
	 * @return int  update status
	 */
	public int updateRoute(Route route) {
		
		curdOperationUtility.updateObjectInDatabase(route);
		return 1;
	}

	/**
	 * This method is to lazy load Route class object from database
	 * 
	 * @param int Id(Primary key) of  Route class object 
	 * @return Route  loaded route object from database
	 */
	public Route loadRoute(int routeId) {
		
		return (Route) curdOperationUtility.loadObjectFromDatabase(Route.class,routeId);
	}

	/**
	 * This method is to load Route class object with early loading of BusDetails from database
	 * 
	 * @param int Id(Primary key) of  Route class object 
	 * @return Route  loaded route object from database
	 */
   @Transactional
   public Route loadRouteWithBusDetails(int routeId) {
		
	   Route route= (Route) curdOperationUtility.loadObjectFromDatabase(Route.class,routeId);
	   
	   // load lazy initialization collections using Hibernate.initialize()
	   Hibernate.initialize(route.getSetOfBusses());
 
	   return route;
	}


}
