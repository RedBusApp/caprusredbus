package com.caprusit.redbus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caprusit.redbus.service.SearchBus_Service;

@Controller
public class SearchBusController {
	
	@Autowired
	private SearchBus_Service searchBusService;
	
	@RequestMapping(value="/searchBusBasedOnSourceAndDestinationStopIds",method=RequestMethod.POST)
	public @ResponseBody String searchBusBasedOnSourceAndDestinationStopIds(@RequestParam("sourceId") int sourceId,@RequestParam("destinationId") int  destinationId){
		System.out.println("source Id: "+sourceId+"  destination Id: "+destinationId);
		return searchBusService.findBussesBasedOnSouceAndDestination(sourceId,destinationId);
	}

}
