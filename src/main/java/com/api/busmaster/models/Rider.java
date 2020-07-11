package com.api.busmaster.models;

public class Rider {
	// Private Attributes
	private int riderId;
	private String fname;
	private String lname;
	private int stopId;
	
	// Public constructors
	public Rider(int riderId, String fname, String lname, int stopId) {
		this.riderId = riderId;
		this.fname = fname;
		this.lname = lname;
		this.stopId = stopId;
	}
	
	public Rider() {}

	// Getters/Setters
	public int getRiderId() {
		return riderId;
	}

	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
}
