package com.caprusit.redbus.service;

import java.util.Set;

public interface SearchBus_Service {
	
	Set<Integer> findRoutesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId);
	
	void findBussesBasedOnRoutes(Set<Integer> routesSet);

	void findBussesBasedOnSouceAndDestination(int sourcebusStopId,int destinationBusStopId);
}
