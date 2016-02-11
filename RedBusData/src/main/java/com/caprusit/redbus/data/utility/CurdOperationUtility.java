package com.caprusit.redbus.data.utility;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;



public class CurdOperationUtility {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	} 

	/**
	 * This method is to save any object into database
	 * 
	 * @param Object object to save into database
	 * @return Serializable ID(primary key) of saved object
	 */
	@Transactional
	public Serializable saveObjectToDatabase(Object object) {

		return sessionFactory.getCurrentSession().save(object);

	}
	
	/**
	 * This method is to update any object in database
	 * 
	 * @param Object object to save into database
	 * @return int 1 successful update
	 */
	@Transactional
	public int updateObjectInDatabase(Object object) {
	
	     sessionFactory.getCurrentSession().merge(object);
	     return 1;
		
	}
	
	/**
	 * This method is to update any object in database
	 * 
	 * @param Object object to save into database
	 * @return int 1 successful update
	 */
	@Transactional(readOnly=true)
	public Object loadObjectFromDatabase(Class<?> clzz,Serializable Id){
		
		return sessionFactory.getCurrentSession().get(clzz,Id);
	}

}
