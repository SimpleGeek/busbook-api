package com.api.busmaster.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.busmaster.models.Stop;

@Repository
public class StopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Stop getNextStop(int prevStopSeqNum) {
		String getNextStopSql =
				"select";
		return new Stop();
	}
}
