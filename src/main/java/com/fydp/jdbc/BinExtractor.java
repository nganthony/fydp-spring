package com.fydp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fydp.domain.Bin;

public class BinExtractor implements ResultSetExtractor<Bin> {

	public Bin extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		Bin bin = new Bin();
		
		bin.setId(resultSet.getInt("id"));
		bin.setBinSystemId(resultSet.getInt("bin_system_id"));
		bin.setName(resultSet.getString("name"));
		bin.setDescription(resultSet.getString("description"));
		bin.setImageUrl(resultSet.getString("image_url"));
		bin.setPurchaseUrl(resultSet.getString("purchase_url"));
		bin.setMassPerItem(resultSet.getDouble("mass_per_item"));
		bin.setTotalMass(resultSet.getDouble("total_mass"));
		bin.setCreatedTimestamp(resultSet.getTimestamp("created_timestamp"));
		
		return bin;
	}

}
