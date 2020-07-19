package com.api.busmaster.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceRecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * This method inserts an attendance record, defaulting to today's
	 * date, for a single rider.
	 * 
	 * @param riderId
	 */
	public void insertAttendanceRecord(int riderId) {
		
	}
}
