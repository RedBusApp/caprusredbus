package com.caprusit.redbus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caprusit.redbus.service.autocomplete.AutoCompleteBusStops_Service;

@Controller
public class AutoCompleteController {
	
	@Autowired
	private AutoCompleteBusStops_Service autoCompleteBusStopService;
	
	@RequestMapping(value="/getAllStopsForAutoComplete",method=RequestMethod.POST)
	public String getAllBusStopsForAutoComplete(){
		
		return autoCompleteBusStopService.getAllBusStops();
	}

}

