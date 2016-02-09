package com.caprusit.redbus.data.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.ManageBus_Data;
import com.caprusit.redbus.domain.BusType;

@Repository
public class ManageBus_DataImpl implements ManageBus_Data {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger=Logger.getLogger(ManageBus_DataImpl.class);

	/**
	 * This method is to save BusType class object into database
	 * 
	 * @param BusType BusType class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	@Transactional
	public int saveBusType(BusType busType) {		
		
	   return (Short)sessionFactory.getCurrentSession().save(busType);
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
			sessionFactory.getCurrentSession().merge(busType);
			return 1;
		}
		catch(Exception e){
			
			logger.error("Exception while updating BusType: "+e.getCause());
			
			return 0;
			
		}
	}

}
