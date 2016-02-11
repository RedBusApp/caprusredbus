package com.caprusit.redbus.service;

import com.caprusit.redbus.domain.BusDetails;

public interface ManageBusDetails_Service {
	
	int saveBusDetails(BusDetails busDetails);
	
	int updateBusDetails(BusDetails busDetails);

}
