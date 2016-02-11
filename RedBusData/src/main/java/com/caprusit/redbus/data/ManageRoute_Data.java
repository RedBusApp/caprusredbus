package com.caprusit.redbus.data;

import com.caprusit.redbus.domain.Route;

public interface ManageRoute_Data {
	
	int saveRoute(Route route);
	int updateRoute(Route route);
	
	Route loadRoute(int routeId);

}
