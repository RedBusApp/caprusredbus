package com.caprusit.redbus.data.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.redbus.data.ManageBusStops_Data;
import com.caprusit.redbus.data.utility.CurdOperationUtility;
import com.caprusit.redbus.domain.BusStop;

@Repository
public class ManageBusStops_DataImpl implements ManageBusStops_Data{
	
	@Autowired
	private CurdOperationUtility curdOperationUtility;
	
	private Logger logger=Logger.getLogger(ManageBusStops_DataImpl.class);

	/**
	 * This method is to save BusStop class object into database
	 * 
	 * @param BusStop BusStop class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	public int saveBusStop(BusStop busStop) {
		
		return (Integer)curdOperationUtility.saveObjectToDatabase(busStop);
	}
	
	/**
	 * This method is to update BusStop class object in database
	 * 
	 * @param BusStop BusStop class object to save into database
	 * @return int  update success message
	 */
	public int updateBusStop(BusStop busStop) {
		
		 return curdOperationUtility.updateObjectInDatabase(busStop);
	}

}
