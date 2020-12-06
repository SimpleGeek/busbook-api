package com.api.busmaster.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	private boolean isAuthenticated;
	private List<Integer> routes;

	public User(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
		routes = new ArrayList<Integer>();
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	public List<Integer> getRoutes() {
		return routes;
	}
	
	public void addRoute(int routeId) {
		if (!routes.contains(routeId)) {
			routes.add(routeId);
		}
	}
}
