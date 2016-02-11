package com.caprusit.redbus.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageBusStops_Data;
import com.caprusit.redbus.domain.BusStop;
import com.caprusit.redbus.service.ManageBusStop_Service;

@Service
public class ManageBusStop_ServiceImpl implements ManageBusStop_Service{

	@Autowired
	private ManageBusStops_Data manageBusStopData;
	
	private Logger logger=Logger.getLogger(ManageBusStop_ServiceImpl.class);
	
	public int saveBusStop(BusStop busStop) {
		
		return manageBusStopData.saveBusStop(busStop);
	}

	public int updateBusStop(BusStop busStop) {
		
		return manageBusStopData.updateBusStop(busStop);
	}

}
