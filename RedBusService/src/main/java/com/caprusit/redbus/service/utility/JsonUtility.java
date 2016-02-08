package com.caprusit.redbus.service.utility;

import com.google.gson.Gson;

public class JsonUtility {
	
	private static Gson gson=null;
	
	/**
	 * This method takes java object and converts object into
	 * JSON string type and returns JSON string
	 * @param obj
	 * @return
	 */
	public static String  converObjectTojson(Object obj){
		
		if(gson == null)
			gson=getGsonObject();
		
		return gson.toJson(obj);
	}
	
	
	private static Gson getGsonObject(){
		
		return new Gson();
		
	}

}
