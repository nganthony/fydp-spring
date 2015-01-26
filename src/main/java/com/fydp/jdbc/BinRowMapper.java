package com.fydp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fydp.domain.Bin;

public class BinRowMapper implements RowMapper<Bin> {

	public Bin mapRow(ResultSet resultSet, int line) throws SQLException {
		
		BinExtractor binExtractor = new BinExtractor();
		return binExtractor.extractData(resultSet);
	}

}
