package com.fydp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fydp.domain.BinData;

public class BinDataRowMapper implements RowMapper<BinData> {

	public BinData mapRow(ResultSet resultSet, int line) throws SQLException {
		
		BinDataExtractor binDataExtractor = new BinDataExtractor();
		return binDataExtractor.extractData(resultSet);
	}
}
