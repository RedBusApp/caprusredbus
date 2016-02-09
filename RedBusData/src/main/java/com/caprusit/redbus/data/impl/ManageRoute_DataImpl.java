package com.caprusit.redbus.data.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.ManageRoute_Data;
import com.caprusit.redbus.domain.Route;

@Repository
public class ManageRoute_DataImpl implements ManageRoute_Data{

	@Autowired
	private SessionFactory sessionfactory;
	
	private Logger logger=Logger.getLogger(ManageRoute_DataImpl.class);
	
	/**
	 * This method is to save Route class object into database
	 * 
	 * @param Route Route class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	@Transactional
	public int saveRoute(Route route) {
				
		return (Integer)sessionfactory.getCurrentSession().save(route);
	}

}
