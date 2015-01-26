package com.fydp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fydp.domain.BinSystem;
import com.fydp.jdbc.BinSystemRowMapper;

@Repository
public class BinSystemDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int insertBinSystem(BinSystem binSystem) {
		final String insertSql = "INSERT INTO bin_system "  
				+ "(name, description) VALUES (?, ?)";

		final Object[] params = new Object[] { binSystem.getName(), binSystem.getDescription() };

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement statement = connection.prepareStatement(insertSql, new String[] {"id"});
						int index = 1;
						for(Object object: params) {
							statement.setObject(index, object);
							index++;
						}
						return statement;
					}
				},
				keyHolder);

		return keyHolder.getKey().intValue();
	}
	
	public BinSystem getBinSystemById(int id) {
		String sql = "SELECT * FROM bin_system WHERE id = ?";
		Object[] params = new Object[] {id};
		
		BinSystem binSystem = jdbcTemplate.queryForObject(sql, params, new BinSystemRowMapper());
		return binSystem;
	}
}
