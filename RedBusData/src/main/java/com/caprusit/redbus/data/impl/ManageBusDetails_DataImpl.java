package com.caprusit.redbus.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.redbus.data.ManageBusDetails_Data;
import com.caprusit.redbus.data.utility.CurdOperationUtility;
import com.caprusit.redbus.domain.BusDetails;

@Repository
public class ManageBusDetails_DataImpl implements ManageBusDetails_Data {

	@Autowired
	private CurdOperationUtility curdOperationUtility;
	
	/**
	 * This method is to save BusDetails class object into database
	 * 
	 * @param BusDetails BusDetails class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	public int saveBusDetails(BusDetails busDetails) {
		
		return (Integer)curdOperationUtility.saveObjectToDatabase(busDetails);
	}

	/**
	 * This method is to update BusDetails class object in database
	 * 
	 * @param BusDetails BusStop class object to save into database
	 * @return int  update success result
	 */
	public int updateBusDetails(BusDetails busDetails) {
	
		return curdOperationUtility.updateObjectInDatabase(busDetails);
	}

}
