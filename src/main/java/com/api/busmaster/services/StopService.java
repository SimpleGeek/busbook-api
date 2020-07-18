package com.api.busmaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.busmaster.daos.StopDao;
import com.api.busmaster.models.Stop;

@Service
public class StopService {
	@Autowired
	private StopDao stopDao;
	
	@Autowired
	private RiderService riderService;
	
	public Stop getNextStop(int prevStopSeqNum, int routeId) {
		Stop nextStop = stopDao.getNextStop(prevStopSeqNum, routeId);
		
		// Retrieve list of riders for this stop
		nextStop.setRiders(riderService.getRidersForStop(nextStop.getStopId()));
		
		return nextStop;
	}
}
