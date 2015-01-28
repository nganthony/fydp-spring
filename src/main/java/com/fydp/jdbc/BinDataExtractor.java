package com.fydp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fydp.domain.BinData;

public class BinDataExtractor implements ResultSetExtractor<BinData> {

	public BinData extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		BinData binData = new BinData();
		
		binData.setId(resultSet.getInt("id"));
		binData.setBinSystemId(resultSet.getInt("bin_system_id"));
		binData.setBinId(resultSet.getInt("bin_id"));
		binData.setData(resultSet.getDouble("data"));
		binData.setCreatedTimestamp(resultSet.getTimestamp("created_timestamp"));
		
		return binData;
	}

}

