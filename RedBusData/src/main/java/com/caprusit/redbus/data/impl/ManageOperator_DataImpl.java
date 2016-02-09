package com.caprusit.redbus.data.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.caprusit.redbus.data.ManageOperator_Data;
import com.caprusit.redbus.domain.Operator;

@Repository
public class ManageOperator_DataImpl implements ManageOperator_Data{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger=Logger.getLogger(ManageOperator_DataImpl.class);
	
	/**
	 * This method is to save Operator class object into database
	 * 
	 * @param Operator Operator class object to save into database
	 * @return int  id(primary key) of saved object
	 */
	@Transactional
	public int saveOperator(Operator operator) {
		
		 return (Integer)sessionFactory.getCurrentSession().save(operator);
	}

}
