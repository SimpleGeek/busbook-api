package com.api.busmaster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.busmaster.models.AttendanceRecord;
import com.api.busmaster.services.AttendanceRecordService;

@RestController
public class AttendanceRecordController {
	@Autowired
	private AttendanceRecordService attendanceService;
	
	@PostMapping("/api/updateriderattendance")
	public void insertAttendanceRecords(@RequestBody List<Integer> riderIds) {
		attendanceService.insertAttendanceRecords(riderIds);
	}
	
	@GetMapping("/api/getattendance/{routeId}")
	public List<AttendanceRecord> getAttendanceRecordsByRoute(@PathVariable("routeId") int routeId) {
		return attendanceService.getAttendanceRecordsByRoute(routeId);
	}
}
