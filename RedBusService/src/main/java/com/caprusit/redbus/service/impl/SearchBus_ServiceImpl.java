package com.caprusit.redbus.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageRoute_Data;
import com.caprusit.redbus.data.SearchBus_Data;
import com.caprusit.redbus.domain.BusDetails;
import com.caprusit.redbus.domain.Route;
import com.caprusit.redbus.service.SearchBus_Service;

@Service
public class SearchBus_ServiceImpl implements SearchBus_Service{
	
	@Autowired
	private SearchBus_Data searchBusData;
	
	@Autowired
	private ManageRoute_Data manageRouteSData;
	
	private Logger logger=Logger.getLogger(SearchBus_ServiceImpl.class);
	
	
	/**
	 * This method is to search routes based on given source and destination 
	 * bustop IDs
	 * 
	 * @param sourcebusStopId source bustop Id
	 * @param destinationBusStopId destination bustopId
	 * @return Set<Integer>  set of routes which are having stops source and destination places
	 */	
	public Set<Integer> findRoutesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId){
		
		Set<Integer> sourceRouteSet,destinationRouteSet,finalRoutesSet;
		
		sourceRouteSet=new HashSet<Integer>(searchBusData.getListOfRoutesBasedOnStopId(sourcebusStopId));
		
		destinationRouteSet=new HashSet<Integer>(searchBusData.getListOfRoutesBasedOnStopId(destinationBusStopId));
		
		finalRoutesSet=new HashSet<Integer>(sourceRouteSet);
		finalRoutesSet.retainAll(destinationRouteSet);
		
		logger.info("source routes  set: : "+sourceRouteSet);
	    
		logger.info("Destination routes  set: : "+destinationRouteSet);
		
		logger.info("Final routes  set: : "+finalRoutesSet);
		
		return finalRoutesSet;
		 
	}


	/**
	 * This method is to find busses which will go through given routes 
	 * 
	 * @param routesSet set of routes to find out busses
	 * @return 
	 */	
	public void findBussesBasedOnRoutes(Set<Integer> routesSet) {
		
		for (Integer routeId:routesSet) {
			 
			System.out.println("route id: " + routeId);
			Route route = manageRouteSData.loadRoute(routeId);
			Set<BusDetails> setBusses = route.getSetOfBusses();
			System.out.println("et of busses size: " + setBusses.size());
			for (BusDetails bus : setBusses) {

				logger.info(" bus id: " + bus.getBusId()
						+ " \n serialNumber: " + bus.getBusSerialNumber()
						+ " \n busType: " + bus.getBusType().getBusTypeName()
						+ " \n operator name: "
						+ bus.getOperator().getOperatorName());
			}
		}
	}


	/**
	 * This method is to find busses based on given source and
	 * destination busStop IDs 
	 * 
	 * @param routesSet set of routes to find out busses
	 * @return 
	 */
	public void findBussesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId) {

		Set<Integer> routesSet=findRoutesBasedOnSouceAndDestination(sourcebusStopId,destinationBusStopId);
		findBussesBasedOnRoutes(routesSet);
		
	}

}
