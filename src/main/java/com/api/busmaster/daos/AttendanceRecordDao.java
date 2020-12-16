package com.api.busmaster.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
		jdbcTemplate.batchUpdate(insertAttendanceRecordSql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) {
				Integer id = riderIds.get(i);
				
				try {
					ps.setInt(1, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public int getBatchSize() {
				return riderIds.size();
			}
		});
	}
}
