package com.api.busmaster.daos;

import java.util.List;

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
	public void insertAttendanceRecords(List<Integer> riderIds) {
		String insertAttendanceRecordSql =
				"insert into attendance_records (attendance_dt, rider_id)\n" +
				"values (current_date, ?)";
		jdbcTemplate.batchUpdate(insertAttendanceRecordSql, riderIds);
	}
}
