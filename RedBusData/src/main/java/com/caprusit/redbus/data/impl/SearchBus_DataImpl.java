package com.caprusit.redbus.data.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.SearchBus_Data;
import com.caprusit.redbus.data.utility.CurdOperationUtility;

@Repository
public class SearchBus_DataImpl implements SearchBus_Data{
	
	@Autowired
	private SessionFactory sesionFactory;
	
	@Autowired
	private CurdOperationUtility curdOperationUtility;

	/**
	 * This method is to search for bus into database
	 * 
	 * @param source source place of journey
	 * @param destination destination place of journey
	 * @return List<Object>  list of busses will go through source and destination
	 */
	@Transactional(readOnly=true)
	public List<Object> searchBus(String source, String destination) {
		return null;
	}
	
	
	
	/**
	 * This method is to search routes based on given  bustop ID
	 * 
	 * @param busStopId  bustop Id to serach for route
	 * @return List<Integer>  list of  routes which are having given bustopId as a stop(halt)
	 */
	@Transactional
	public List<Integer> getListOfRoutesBasedOnStopId(int busStopId){
		
		String hql="select routes.routeId from  BusStop bs join bs.setOfRoutes as routes where bs.busStopId= :busStopId";
		return sesionFactory.getCurrentSession().createQuery(hql).setParameter("busStopId", busStopId).list();
	}


}
