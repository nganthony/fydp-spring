package com.fydp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fydp.domain.BinSystem;

public class BinSystemRowMapper implements RowMapper<BinSystem> {

	public BinSystem mapRow(ResultSet resultSet, int line) throws SQLException {
		
		BinSystemExtractor binSystemExtractor = new BinSystemExtractor();
		return binSystemExtractor.extractData(resultSet);
	}

}
