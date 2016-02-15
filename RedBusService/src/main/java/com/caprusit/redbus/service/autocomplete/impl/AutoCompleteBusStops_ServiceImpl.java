package com.caprusit.redbus.service.autocomplete.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.autocomplete.AutoCompleteBusStops_Data;
import com.caprusit.redbus.service.autocomplete.AutoCompleteBusStops_Service;
import com.caprusit.redbus.service.utility.JsonUtility;

@Service
public class AutoCompleteBusStops_ServiceImpl implements AutoCompleteBusStops_Service{

	@Autowired
	private AutoCompleteBusStops_Data autoCompleteBusStopsData;
	
	private Logger logger=Logger.getLogger(AutoCompleteBusStops_ServiceImpl.class);
	
	public String getAllBusStops() {
		
		String allStops=JsonUtility.converObjectTojson(autoCompleteBusStopsData.getAllBusStops());		
		logger.info("all bsuStops: "+allStops);
		return allStops;
	}

}
