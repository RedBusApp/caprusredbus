package com.caprusit.redbus.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.redbus.data.ManageOperator_Data;
import com.caprusit.redbus.domain.Operator;
import com.caprusit.redbus.service.ManageOperator_Service;

@Service
public class ManageOperator_ServiceImpl implements ManageOperator_Service {
	
	@Autowired
	private ManageOperator_Data manageOperatorData;
	
	private Logger logger=Logger.getLogger(ManageOperator_ServiceImpl.class);
	

	public int saveOperator(Operator operator) {
	
		return manageOperatorData.saveOperator(operator);
	}


}
