package com.api.busmaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.busmaster.daos.RiderDao;
import com.api.busmaster.models.Rider;

@Service
public class RiderService {
	@Autowired
	private RiderDao riderDao;
	
	public Rider getRider() {
		return riderDao.getRider();
	}
}
