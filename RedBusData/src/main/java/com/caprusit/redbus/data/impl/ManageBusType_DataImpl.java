package com.caprusit.redbus.data.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.ManageBusType_Data;
import com.caprusit.redbus.data.utility.CurdOperationUtility;
import com.caprusit.redbus.domain.BusType;

@Repository
public class ManageBusType_DataImpl implements ManageBusType_Data {
	
	@Autowired
	private CurdOperationUtility curdOperationUtility;
	
	private Logger logger=Logger.getLogger(ManageBusType_DataImpl.class);

	/**
	 * This method is to save BusType class object into database
	 * 
	 * @param BusType BusType class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	public int saveBusType(BusType busType) {		
		
	   return (Short)curdOperationUtility.saveObjectToDatabase(busType);
	}

	/**
	 * This method is to update BusType class object into database
	 * 
	 * @param BusType BusType class object which is update into database
	 * @return int  1 means update success, 0 means failed
	 */
	@Transactional
	public int updateBusType(BusType busType) {
		
		try{
			//sessionFactory.getCurrentSession().merge(busType);
			return 1;
		}
		catch(Exception e){
			
			logger.error("Exception while updating BusType: "+e.getCause());
			
			return 0;
			
		}
	}

}
