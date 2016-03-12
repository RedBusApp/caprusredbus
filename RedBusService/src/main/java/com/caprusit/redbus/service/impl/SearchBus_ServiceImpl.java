package com.caprusit.redbus.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageRoute_Data;
import com.caprusit.redbus.data.SearchBus_Data;
import com.caprusit.redbus.domain.BusDetails;
import com.caprusit.redbus.domain.Bus_User_Utiltity;
import com.caprusit.redbus.domain.Route;
import com.caprusit.redbus.service.SearchBus_Service;
import com.caprusit.redbus.service.utility.JsonUtility;

@Service
public class SearchBus_ServiceImpl implements SearchBus_Service {

	@Autowired
	private SearchBus_Data searchBusData;

	@Autowired
	private ManageRoute_Data manageRouteData;

	private Logger logger = Logger.getLogger(SearchBus_ServiceImpl.class);

	/**
	 * This method is to search routes based on given source and destination
	 * bus stop IDs
	 * 
	 * @param sourcebusStopId  source bus stop Id
	 * @param destinationBusStopId destination bus stop Id
	 * @return Set<Integer> set of routes which are having stops source and
	 *         destination places
	 */
	public Set<Integer> findRoutesBasedOnSouceAndDestination(int sourcebusStopId, int destinationBusStopId) {

		Set<Integer> sourceRouteSet, destinationRouteSet, finalRoutesSet;
		sourceRouteSet = new HashSet<Integer>(searchBusData.getListOfRoutesBasedOnStopId(sourcebusStopId));
		destinationRouteSet = new HashSet<Integer>(searchBusData.getListOfRoutesBasedOnStopId(destinationBusStopId));
		finalRoutesSet = new HashSet<Integer>(sourceRouteSet);		
		//retainAll() gives intersection of two sets
		finalRoutesSet.retainAll(destinationRouteSet);
		logger.info("source routes  set: : " + sourceRouteSet);
		logger.info("Destination routes  set: : " + destinationRouteSet);
		logger.info("Final routes  set: : " + finalRoutesSet);
		return finalRoutesSet;

	}

	/**
	 * This method is to find busses which will go through given routes
	 * 
	 * @param routesSet  set of routes to find out busses
	 * @return List<Bus_User_Utiltity>  list of bus details which are traveling 
	 *         through given routes
	 */
	public List<Bus_User_Utiltity> findBussesBasedOnRoutes(Set<Integer> routesSet) {

	
		Bus_User_Utiltity busUtuluity;
		List<Bus_User_Utiltity> listOfBusses=new ArrayList<Bus_User_Utiltity>();
		
		for (Integer routeId : routesSet) {

			System.out.println("route id: " + routeId);
			Route route = manageRouteData.loadRoute(routeId);
			Set<BusDetails> setBusses = route.getSetOfBusses();
			System.out.println("et of busses size: " + setBusses.size());
			for (BusDetails bus : setBusses) {
				// check status, status 1 means bus is ready for journey
				if(bus.getStatus() == 1){

				     busUtuluity=new Bus_User_Utiltity();
				
				     busUtuluity.setBusId(bus.getBusId());
				     busUtuluity.setBusSerialNumber(bus.getBusSerialNumber());
				     busUtuluity.setBusType( bus.getBusType().getBusTypeName());
				     busUtuluity.setNumberOfSeats(bus.getBusType().getNumberOfSeats());
				     busUtuluity.setOperatorName( bus.getOperator().getOperatorName());
				
				     listOfBusses.add(busUtuluity);
			    }
			}
		}

		return listOfBusses;
	}

	/**
	 * This method is to find busses based on given source and destination
	 * busStop IDs
	 * 
	 * @param sourcebusStopId  source bus stop id
	 * @param destinationBusStopId destination bus stop id
	 * @return String  JSON object array string which contains all bus details which are traveling 
	 *         through given source and destination bus stops
	 */
	public String findBussesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId) {

		Set<Integer> routesSet = findRoutesBasedOnSouceAndDestination(sourcebusStopId, destinationBusStopId);
		Map<String,Object> busDetailsMap=new HashMap<String, Object>();
		busDetailsMap.put("sourceBoardinPoints", "");
		busDetailsMap.put("detinationBoardinPoints", "");
		busDetailsMap.put("listOfBusses",findBussesBasedOnRoutes(routesSet) );
		return JsonUtility.converObjectTojson(busDetailsMap);
	}

}
