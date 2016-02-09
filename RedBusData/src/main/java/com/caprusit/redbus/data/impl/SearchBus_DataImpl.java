package com.caprusit.redbus.data.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.redbus.data.SearchBus_Data;

@Repository
public class SearchBus_DataImpl implements SearchBus_Data{
	
	@Autowired
	private SessionFactory sesionFactory;

	
	public List<Object> searchBus(String source, String destination) {

		return null;
	}

}
