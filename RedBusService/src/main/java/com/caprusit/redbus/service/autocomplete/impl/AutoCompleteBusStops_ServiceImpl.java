package com.caprusit.redbus.service.autocomplete.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.autocomplete.AutoCompleteBusStops_Data;
import com.caprusit.redbus.service.autocomplete.AutoCompleteBusStops_Service;
import com.caprusit.redbus.service.utility.JsonUtility;

@Service
public class AutoCompleteBusStops_ServiceImpl implements AutoCompleteBusStops_Service{

	
	public AutoCompleteBusStops_ServiceImpl() {
		super();
		System.out.println("autocomplete bus stop crearted");
	}

	@Autowired
	private AutoCompleteBusStops_Data autoCompleteBusStopsData;
	
	public String getAllBusStops() {
		String str=JsonUtility.converObjectTojson(autoCompleteBusStopsData.getAllBusStops());
		
		System.out.println("json string"+str);
		return str;
	}

}
