package com.api.busmaster.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.api.busmaster.models.AttendanceRecord;

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
				"values (?, ?)";
		jdbcTemplate.batchUpdate(insertAttendanceRecordSql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) {
				Integer id = riderIds.get(i);
				
				try {
					ps.setTimestamp(1, Timestamp.from(Instant.now()));
					ps.setInt(2, id);
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
	
	public List<AttendanceRecord> getAttendanceRecordsByRoute(int routeId) {
		List<AttendanceRecord> attendanceRecords = new ArrayList<AttendanceRecord>();
		String getAttendanceRecordsByRouteSql =
				"select ar.attendance_rec_id,\n" +
				"       ar.attendance_dt,\n" +
				"       ar.rider_id\n" +
				"  from attendance_records ar,\n" +
				"       stops s,\n" +
				"       riders r\n" +
				" where s.route_id = ?\n" +
				"   and r.stop_id = s.stop_id\n" +
				"   and ar.rider_id = r.rider_id\n" +
				"order by ar.attendance_dt";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getAttendanceRecordsByRouteSql, routeId);
		while (rs.next()) {
			attendanceRecords.add(new AttendanceRecord(rs.getInt("attendance_rec_id"),
									rs.getTimestamp("attendance_dt").toInstant(), rs.getInt("rider_id")));
		}
		return attendanceRecords;
	}
}
