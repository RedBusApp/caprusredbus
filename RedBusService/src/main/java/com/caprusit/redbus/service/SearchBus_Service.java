package com.caprusit.redbus.service;

import java.util.List;
import java.util.Set;

import com.caprusit.redbus.domain.Bus_User_Utiltity;

public interface SearchBus_Service {
	
	Set<Integer> findRoutesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId);
	
	 List<Bus_User_Utiltity> findBussesBasedOnRoutes(Set<Integer> routesSet);

	String findBussesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId);
}
