package com.fydp.dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BinDataDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insertData(int binSystemId, int binId, double data, long createdTimestamp) {
		final String sql = "INSERT INTO bin_data "  
				+ "(bin_system_id, bin_id, data, created_timestamp) VALUES (?, ?, ?, ?)";
	    
		Date date = new Date(createdTimestamp * 1000);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		final Object[] params = new Object[] {binSystemId, binId, data, df.format(date)};

		jdbcTemplate.update(sql, params);
	}
	
	public List<Double> getAllData(int binSystemId, int binId) {
		List<Double> result = new ArrayList<Double>();
		
		final String sql = "SELECT data FROM bin_data WHERE bin_system_id = ? AND bin_id = ?";
		
		Object[] params = new Object[] {binSystemId, binId};
		
		result = jdbcTemplate.queryForList(sql, params, Double.class);
		return result;
	}
}
