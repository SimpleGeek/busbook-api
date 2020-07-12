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
				"		\n" +
				"       stop_id\n" +
				"from public.riders";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getRiderSql);
		while(rs.next()) {
			riders.add(new Rider(rs.getInt("rider_id"), rs.getString("fname"),
								 rs.getString("lname"), rs.getInt("stop_id")));
		}
		return riders;
	}
}
