package com.caprusit.redbus.data;

import java.util.List;

public interface SearchBus_Data {
	
	    List<Object> searchBus(String source,String destination);
	    
	    List<Integer> getListOfRoutesBasedOnStopId(int busStopId);
}
