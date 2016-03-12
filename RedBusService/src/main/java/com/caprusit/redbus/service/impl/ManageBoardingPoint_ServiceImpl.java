package com.caprusit.redbus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageBoardinPoint_Data;
import com.caprusit.redbus.domain.BoardingPoint;
import com.caprusit.redbus.service.ManageBoardingPoint_Service;

@Service
public class ManageBoardingPoint_ServiceImpl implements ManageBoardingPoint_Service{

	@Autowired
	private ManageBoardinPoint_Data manageBoardinPointData;
	
	public int saveBoardingpoint(BoardingPoint boardingPoint) {
		
		return manageBoardinPointData.saveBoardingpoint(boardingPoint);
	}

}
