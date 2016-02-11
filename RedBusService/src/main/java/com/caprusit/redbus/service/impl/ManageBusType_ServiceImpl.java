package com.caprusit.redbus.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageBusType_Data;
import com.caprusit.redbus.domain.BusType;
import com.caprusit.redbus.service.ManageBusType_Service;

@Service("manageBusService")
public class ManageBusType_ServiceImpl implements ManageBusType_Service{
	
	@Autowired
	private ManageBusType_Data manageBusData;
	
	private Logger logger=Logger.getLogger(ManageBusType_ServiceImpl.class);
	
	/**
	 * 
	 */
	public int saveBusType(BusType busType){
		logger.info(" saveBusType() executing ");
		return manageBusData.saveBusType(busType);
	}

}
