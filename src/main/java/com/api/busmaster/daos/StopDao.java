package com.api.busmaster.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.api.busmaster.models.Stop;

@Repository
public class StopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * This method returns the next stop in a route, given the sequence
	 * number of the previous stop, and the id of the route.
	 * 
	 * @param prevStopSeqNum
	 * @param routeId
	 * @return
	 */
	public Stop getNextStop(int prevStopSeqNum, int routeId) {
		String getNextStopSql =
				"select stop_id,\n" +
				"       seq_num,\n" +
				"       street_addr,\n" +
				"       city,\n" +
				"       state_abbr,\n" +
				"       zip,\n" +
				"       apartment,\n" +
				"       building,\n" +
				"       door,\n" +
				"       route_id\n" +
				"  from stops\n" +
				" where seq_num = ?\n" +
				"   and route_id = ?";
		
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getNextStopSql, (prevStopSeqNum + 1), routeId);
		Stop nextStop = new Stop();
		while (rs.next()) {
			nextStop.setStopid(rs.getInt("stop_id"));
			nextStop.setSeqNum(rs.getInt("seq_num"));
			nextStop.setStreetAddr(rs.getString("street_addr"));
			nextStop.setCity(rs.getString("city"));
			nextStop.setStateAbbr(rs.getString("state_abbr"));
			nextStop.setZip(rs.getString("zip"));
			nextStop.setApartment(rs.getString("apartment"));
			nextStop.setBuilding(rs.getString("building"));
			nextStop.setDoor(rs.getString("door"));
			nextStop.setRouteId(rs.getInt("route_id"));
		}
		return nextStop;
	}
}
