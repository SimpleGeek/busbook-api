package com.api.busmaster.models;

import java.util.List;

public class Stop {
	// Private attributes
	private int stopId;
	private int seqNum;
	private String streetAddr;
	private String city;
	private String stateAbbr;
	private String zip;
	private String apartment;
	private String building;
	private String door;
	private int routeId;
	private boolean isLastStop;
	private List<Rider> riders;
	
	// Public constructors
	public Stop() {}
	
	public Stop(int stopId, int seqNum, String streetAddr, String city, String stateAbbr, String zip, String apartment,
			String building, String door, int routeId, boolean isLastStop) {
		this.stopId = stopId;
		this.seqNum = seqNum;
		this.streetAddr = streetAddr;
		this.city = city;
		this.stateAbbr = stateAbbr;
		this.zip = zip;
		this.apartment = apartment;
		this.building = building;
		this.door = door;
		this.routeId = routeId;
		this.isLastStop = isLastStop;
	}

	// Getters/Setters
	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopid) {
		this.stopId = stopid;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public String getStreetAddr() {
		return streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateAbbr() {
		return stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public boolean isLastStop() {
		return isLastStop;
	}

	public void setIsLastStop(boolean isLastStop) {
		this.isLastStop = isLastStop;
	}

	public List<Rider> getRiders() {
		return riders;
	}

	public void setRiders(List<Rider> riders) {
		this.riders = riders;
	}
	
	public void addRider(Rider rider) {
		this.riders.add(rider);
	}
}
