package com.api.busmaster.models;

public class Route {
	// Private attributes
	private int routeId;
	private int busNum;
	
	// Public constructors
	public Route() {}
	
	public Route(int routeId, int busNum) {
		this.routeId = routeId;
		this.busNum = busNum;
	}

	// Getters/Setters
	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getBusNum() {
		return busNum;
	}

	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
}
