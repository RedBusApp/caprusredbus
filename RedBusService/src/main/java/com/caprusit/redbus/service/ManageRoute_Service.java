package com.caprusit.redbus.service;

import com.caprusit.redbus.domain.Route;

public interface ManageRoute_Service {

	int saveRoute(Route route);

	int updateRoute(Route route);

	Route loadRoute(int routeId);

}
