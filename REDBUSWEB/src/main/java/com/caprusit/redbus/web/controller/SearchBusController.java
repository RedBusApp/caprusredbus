package com.caprusit.redbus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caprusit.redbus.service.SearchBus_Service;

@Controller
public class SearchBusController {
	
	@Autowired
	private SearchBus_Service searchBusService;
	
	@RequestMapping(value="/searchBusBasedOnSourceAndDestinationStopIds",method=RequestMethod.GET)
	public String searchBusBasedOnSourceAndDestinationStopIds(){
		
		return null;
	}

}
