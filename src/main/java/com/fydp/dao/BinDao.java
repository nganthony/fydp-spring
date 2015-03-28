package com.fydp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fydp.domain.Bin;
import com.fydp.jdbc.BinRowMapper;

@Repository
public class BinDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int insertBin(Bin bin) {
		final String insertSql = "INSERT INTO bin "  
				+ "(bin_system_id, name, description, image_url, " 
				+ "purchase_url, mass_per_item, total_mass) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		final Object[] params = new Object[] {bin.getBinSystemId(), bin.getName(), 
				bin.getDescription(), bin.getImageUrl(), bin.getPurchaseUrl(), 
				bin.getMassPerItem(), bin.getTotalMass()};
		
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
	
	public Bin getBinById(int id) {
		String sql = "SELECT * FROM bin WHERE id = ?";
		Object[] params = new Object[] {id};
		
		Bin bin = jdbcTemplate.queryForObject(sql, params, new BinRowMapper());
		return bin;
	}
	
	public List<Bin> getBinsBySystemId(int binSystemId) {
		String sql = "SELECT * FROM bin WHERE bin_system_id = ?";
		Object[] params = new Object[] {binSystemId};
		
		List<Bin> bins = jdbcTemplate.query(sql, params, new BinRowMapper());
		return bins;
	}
	
	public void updateCurrentMass(int binSystemId, int binId, double data) {
		String sql = "UPDATE bin" + 
					" SET current_mass = ?" + 
					" WHERE bin_system_id = ? AND id = ?";
		
		Object[] params = new Object[] {data, binSystemId, binId};
		jdbcTemplate.update(sql, params);
	}
}
