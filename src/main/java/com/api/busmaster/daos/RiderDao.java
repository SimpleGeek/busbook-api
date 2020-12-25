package com.api.busmaster.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.api.busmaster.models.Rider;

@Repository
public class RiderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Rider> getRiders() {
		List<Rider> riders = new ArrayList<Rider>();
		String getRiderSql =
				"select rider_id,\n" +
				"       fname,\n" +
				"       lname,\n" +
				"       age(birthday) as age_str,\n" +
				"		birthday,\n" +
				"       stop_id\n" +
				"from riders";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getRiderSql);
		while(rs.next()) {
			riders.add(new Rider(rs.getInt("rider_id"), rs.getString("fname"), rs.getString("lname"), 
								 getYearsFromAgeStr(rs.getString("age_str")), rs.getTimestamp("birthday").toInstant(),
								 rs.getInt("stop_id")));
		}
		return riders;
	}
	
	public List<Rider> getRidersForStop(int stopId) {
		String getRidersForStopSql =
				"select rider_id,\n" +
				"       fname,\n" +
				"       lname,\n" +
				"       age(birthday) as age_str,\n" +
				"		birthday,\n" +
				"       stop_id\n" +
				"  from riders\n" +
				" where stop_id = ?";
		
		List<Rider> stopRiders = new ArrayList<Rider>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getRidersForStopSql, stopId);
		while (rs.next()) {
			stopRiders.add(new Rider(rs.getInt("rider_id"), rs.getString("fname"), rs.getString("lname"), 
									 getYearsFromAgeStr(rs.getString("age_str")), rs.getTimestamp("birthday").toInstant(),
									 rs.getInt("stop_id")));
		}
		return stopRiders;
	}
	
	public void insertRiders(List<Rider> riders) {
		String insertRidersSql =
				"insert into riders(fname, lname, birthday, stop_id)\n" +
				"values(?, ?, ?, ?)";
		jdbcTemplate.batchUpdate(insertRidersSql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) {
				Rider r = riders.get(i);
				
				try {
					ps.setString(1, r.getFname());
					ps.setString(2, r.getLname());
					ps.setTimestamp(3, Timestamp.from(r.getBirthday()));
					ps.setInt(4, r.getStopId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public int getBatchSize() {
				return riders.size();
			}
		});
	}
	
	// Private utility methods
	/**
	 * This method accepts the output of a postgres AGE function call as a string,
	 * and returns an integer for the age in years.
	 * 
	 * @param ageStr
	 * @return
	 */
	// TODO: Move this to a more generic util class
	private int getYearsFromAgeStr(String ageStr) {
		// The postgres AGE function returns the age in a string formatted like so:
		// XX years XX mons XX days
		// In this case, we only care about the years, so we're simply pulling out
		// the first two characters of that string.
		return Integer.parseInt(ageStr.substring(0, 2).trim());
	}
}
