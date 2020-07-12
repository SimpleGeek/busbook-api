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
			// The postgres AGE function returns the age in a string formatted like so:
			// XX years XX mons XX days
			// In this case, we only care about the years, so we're simply pulling out
			// the first two characters of that string.
			int age = Integer.parseInt(rs.getString("age_str").substring(0, 2).trim());
			riders.add(new Rider(rs.getInt("rider_id"), rs.getString("fname"),
								 rs.getString("lname"), age, rs.getString("birthday"), rs.getInt("stop_id")));
		}
		return riders;
	}
}
