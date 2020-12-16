package com.api.busmaster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.busmaster.daos.AttendanceRecordDao;

@Service
public class AttendanceRecordService {
	@Autowired
	private AttendanceRecordDao attendanceDao;
	
	public void insertAttendanceRecords(List<Integer> riderIds) {
		attendanceDao.insertAttendanceRecords(riderIds);
	}
}
