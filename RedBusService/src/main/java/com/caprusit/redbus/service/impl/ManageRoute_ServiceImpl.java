package com.caprusit.redbus.service.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageRoute_Data;
import com.caprusit.redbus.domain.BusStop;
import com.caprusit.redbus.domain.Operator;
import com.caprusit.redbus.domain.Route;
import com.caprusit.redbus.service.ManageRoute_Service;

@Service
public class ManageRoute_ServiceImpl implements ManageRoute_Service {

	@Autowired
	private ManageRoute_Data manageRoute_data;
	
	private Logger logger=Logger.getLogger(ManageRoute_ServiceImpl.class);
	
	public int saveRoute(Route route) {
		
		return manageRoute_data.saveRoute(route);
	}

	public int updateRoute(Route route) {
		
		return manageRoute_data.updateRoute(route);
	}

	public Route loadRoute(int routeId) {
		
		return manageRoute_data.loadRoute(routeId);
	}

}
