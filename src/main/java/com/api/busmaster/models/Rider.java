package com.api.busmaster.models;

public class Rider {
	// Private Attributes
	private int riderId;
	private String fname;
	private String lname;
	private int age; // Age in whole years old
	private String birthday;
	private int stopId;
	
	// Public constructors
	public Rider() {}
	
	public Rider(int riderId, String fname, String lname, int age, String birthday, int stopId) {
		this.riderId = riderId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.birthday = birthday;
		this.stopId = stopId;
	}

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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
}
