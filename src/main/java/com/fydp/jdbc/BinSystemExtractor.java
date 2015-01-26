package com.fydp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fydp.domain.BinSystem;

public class BinSystemExtractor implements ResultSetExtractor<BinSystem> {

	public BinSystem extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		BinSystem binSystem = new BinSystem();
		
		binSystem.setId(resultSet.getInt("id"));
		binSystem.setName(resultSet.getString("name"));
		binSystem.setDescription(resultSet.getString("description"));
		binSystem.setCreatedTimestamp(resultSet.getTimestamp("created_timestamp"));
		
		return binSystem;
	}

}
