package com.api.busmaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.busmaster.daos.StopDao;
import com.api.busmaster.models.Stop;

@Service
public class StopService {
	@Autowired
	private StopDao stopDao;
	
	public Stop getNextStop(int prevStopSeqNum, int routeId) {
		Stop nextStop = stopDao.getNextStop(prevStopSeqNum, routeId);
		System.out.println("Stop id: " + nextStop.getStopId());
		
		// Retrieve list of riders for this stop
		RiderService riderService = new RiderService();
		nextStop.setRiders(riderService.getRidersForStop(nextStop.getStopId()));
		
		return nextStop;
	}
}
