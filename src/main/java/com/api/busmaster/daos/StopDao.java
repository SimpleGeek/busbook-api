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
		int lastSeqNum = getLastStopSeqInRoute(routeId);
		while (rs.next()) {
			nextStop.setStopId(rs.getInt("stop_id"));
			nextStop.setSeqNum(rs.getInt("seq_num"));
			nextStop.setStreetAddr(rs.getString("street_addr"));
			nextStop.setCity(rs.getString("city"));
			nextStop.setStateAbbr(rs.getString("state_abbr"));
			nextStop.setZip(rs.getString("zip"));
			nextStop.setApartment(rs.getString("apartment"));
			nextStop.setBuilding(rs.getString("building"));
			nextStop.setDoor(rs.getString("door"));
			nextStop.setRouteId(rs.getInt("route_id"));
			nextStop.setIsLastStop(lastSeqNum == nextStop.getSeqNum());
		}
		return nextStop;
	}
	
	/**
	 * Get the maximum stop sequence number
	 * for the route.  This is useful for determining
	 * if a given stop is the last one in the route.
	 * 
	 * @param routeId
	 * @return
	 */
	public int getLastStopSeqInRoute(int routeId) {
		String getLastStopSeqSql =
				"select max(seq_num) last_seq_num\n" +
				"  from stops\n" +
				" where route_id = ?";
		
		SqlRowSet rs = jdbcTemplate.queryForRowSet(getLastStopSeqSql, routeId);
		rs.next();
		return rs.getInt("last_seq_num");
	}
	
	/**
	 * This method accepts a sequence number and route id,
	 * and shifts all stops in that route with a sequence
	 * number >= the sequence number parameter up by 1.
	 * Warning: this creates a hole in the route sequencing,
	 * which allows for a new stop to be inserted in the middle
	 * of the route, but could also cause problems for users if
	 * a hole is left, as the interface won't be aware of the hole.
	 * 
	 * @param shiftFrom
	 * @param routeId
	 */
	public void shiftStopSequencesUp(int shiftFrom, int routeId) {
		String shiftStopSequencesSql =
				"update stops\n" +
				"   set seq_num = (seq_num + 1)\n" +
				" where seq_num >= ?\n" +
				"   and route_id = ?";
		jdbcTemplate.update(shiftStopSequencesSql, shiftFrom, routeId);
	}
	
	public void insertStop(Stop stop) {
		String insertStopSql =
				"insert into stops(seq_num, street_addr, city, state_abbr, zip, apartment, building, door, route_id)\n" +
				"values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertStopSql, stop.getSeqNum(), stop.getStreetAddr(), stop.getCity(), stop.getStateAbbr(),
							stop.getZip(), stop.getApartment(), stop.getBuilding(), stop.getDoor(), stop.getRouteId());
	}
	
	public int getStopIdBySeqNumAndRouteId(int seqNum, int routeId) {
		String getStopIdSql =
				"select stop_id\n" +
				"  from stops\n" +
				" where seq_num = ?\n" +
				"   and route_id = ?";
		return jdbcTemplate.queryForObject(getStopIdSql, Integer.class, seqNum, routeId);
	}
}
