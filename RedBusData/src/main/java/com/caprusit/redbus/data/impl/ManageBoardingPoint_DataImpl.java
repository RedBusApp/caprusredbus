package com.caprusit.redbus.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.redbus.data.ManageBoardinPoint_Data;
import com.caprusit.redbus.data.utility.CurdOperationUtility;
import com.caprusit.redbus.domain.BoardingPoint;

@Repository
public class ManageBoardingPoint_DataImpl implements ManageBoardinPoint_Data{

	@Autowired
	private CurdOperationUtility curdOperationUtility;
	
	public int saveBoardingpoint(BoardingPoint boardingPoint) {
		
		return (Integer) curdOperationUtility.saveObjectToDatabase(boardingPoint);
	}

}
