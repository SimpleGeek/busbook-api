package com.api.busmaster.daos;

import org.springframework.stereotype.Repository;

import com.api.busmaster.models.Rider;

@Repository
public class RiderDao {
	
	public Rider getRider() {
		return new Rider(1, "Joe", "Tester", 1);
	}
}
