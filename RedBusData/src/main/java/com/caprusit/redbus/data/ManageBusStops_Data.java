package com.caprusit.redbus.data;

import com.caprusit.redbus.domain.BusStop;

public interface ManageBusStops_Data {
	
	int saveBusStop(BusStop busStop);
	
	int updateBusStop(BusStop busStop);

}
