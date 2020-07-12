package com.api.busmaster.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
				"		to_char(birthday, 'Mon dd, yyyy') as birthday,\n" +
				"       stop_id\n" +
				"from riders";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getRiderSql);
		while(rs.next()) {
			riders.add(new Rider(rs.getInt("rider_id"), rs.getString("fname"), rs.getString("lname"), 
								 getYearsFromAgeStr(rs.getString("age_str")), rs.getString("birthday"), rs.getInt("stop_id")));
		}
		return riders;
	}
	
	public List<Rider> getRidersForStop(int stopId) {
		String getRidersForStopSql =
				"select rider_id,\n" +
				"       fname,\n" +
				"       lname,\n" +
				"       age(birthday) as age_str,\n" +
				"		to_char(birthday, 'Mon dd, yyyy') as birthday,\n" +
				"       stop_id\n" +
				"  from riders\n" +
				" where stop_id = ?";
		
		List<Rider> stopRiders = new ArrayList<Rider>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getRidersForStopSql, stopId);
		while (rs.next()) {
			stopRiders.add(new Rider(rs.getInt("rider_id"), rs.getString("fname"), rs.getString("lname"), 
									 getYearsFromAgeStr(rs.getString("age_str")), rs.getString("birthday"), rs.getInt("stop_id")));
		}
		return stopRiders;
	}
	
	// Private utility methods
	/**
	 * This method accepts the output of a postgres AGE function call as a string,
	 * and returns an integer for the age in years.
	 * 
	 * @param ageStr
	 * @return
	 */
	private int getYearsFromAgeStr(String ageStr) {
		// The postgres AGE function returns the age in a string formatted like so:
		// XX years XX mons XX days
		// In this case, we only care about the years, so we're simply pulling out
		// the first two characters of that string.
		return Integer.parseInt(ageStr.substring(0, 2).trim());
	}
}
