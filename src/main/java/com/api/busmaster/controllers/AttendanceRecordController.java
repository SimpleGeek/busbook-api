package com.api.busmaster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.busmaster.models.Rider;
import com.api.busmaster.services.AttendanceRecordService;

@RestController
public class AttendanceRecordController {
	@Autowired
	private AttendanceRecordService attendanceService;
	
	@PostMapping("/api/updateriderattendance")
	public void insertAttendanceRecords(List<Rider> riders) {
		attendanceService.insertAttendanceRecords(riders);
	}
}
