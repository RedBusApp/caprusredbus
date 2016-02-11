package com.caprusit.redbus.data.autocomplete.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.autocomplete.AutoCompleteBusStops_Data;
import com.caprusit.redbus.domain.BusStop;

@Repository
public class AutoComplateBusStops_DataImpl  implements AutoCompleteBusStops_Data{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Object> getAllBusStops() {
		
		ProjectionList pList=Projections.projectionList();
		pList.add(Projections.property("busStopId"));
		pList.add(Projections.property("busStopName"));
		return sessionFactory.getCurrentSession().createCriteria(BusStop.class).setProjection(pList).list();
	}

}
