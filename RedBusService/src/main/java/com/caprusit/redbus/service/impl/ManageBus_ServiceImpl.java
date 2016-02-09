package com.caprusit.redbus.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageBus_Data;
import com.caprusit.redbus.domain.BusType;
import com.caprusit.redbus.service.ManageBus_Service;

@Service("manageBusService")
public class ManageBus_ServiceImpl implements ManageBus_Service{
	
	@Autowired
	private ManageBus_Data manageBusData;
	
	private Logger logger=Logger.getLogger(ManageBus_ServiceImpl.class);
	
	/**
	 * 
	 */
	public int saveBusType(BusType busType){
		logger.info(" saveBusType() executing ");
		return manageBusData.saveBusType(busType);
	}

}
