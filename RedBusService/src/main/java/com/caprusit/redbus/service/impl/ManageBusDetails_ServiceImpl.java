package com.caprusit.redbus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageBusDetails_Data;
import com.caprusit.redbus.domain.BusDetails;
import com.caprusit.redbus.service.ManageBusDetails_Service;

@Service
public class ManageBusDetails_ServiceImpl implements ManageBusDetails_Service {

	@Autowired
	private ManageBusDetails_Data manageBusDetailsData;
	
	public int saveBusDetails(BusDetails busDetails) {
		
		return manageBusDetailsData.saveBusDetails(busDetails);
	}

	public int updateBusDetails(BusDetails busDetails) {
		
		return manageBusDetailsData.updateBusDetails(busDetails);
	}

}
