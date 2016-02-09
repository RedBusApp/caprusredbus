package com.caprusit.redbus.data.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.ManageBusStops_Data;
import com.caprusit.redbus.domain.BusStop;

@Repository
public class ManageBusStops_DataImpl implements ManageBusStops_Data{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger=Logger.getLogger(ManageBusStops_DataImpl.class);

	/**
	 * This method is to save BusStop class object into database
	 * 
	 * @param BusStop BusStop class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	@Transactional
	public int saveBusStop(BusStop busStop) {
		
		return (Integer)sessionFactory.getCurrentSession().save(busStop);
	}

}
