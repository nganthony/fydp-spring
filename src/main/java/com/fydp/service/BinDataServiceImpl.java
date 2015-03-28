package com.fydp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fydp.dao.BinDao;
import com.fydp.dao.BinDataDao;
import com.fydp.domain.BinData;

@Service
public class BinDataServiceImpl implements BinDataService {

	private static double BIN_WEIGHT = 56.0;
	
	@Autowired
	BinDataDao binDataDao;
	
	@Autowired
	BinDao binDao;
	
	public void sendData(int binSystemId, int binId, double data, long createdTimestamp) {
		
		data -= BIN_WEIGHT;
		
		if(data < 0) {
			data = 0;
		}
		
		binDataDao.insertData(binSystemId, binId, data, createdTimestamp);
		binDao.updateCurrentMass(binSystemId, binId, data);
	}

	public List<BinData> getAllData(int binSystemId, int binId) {
		return binDataDao.getAllData(binSystemId, binId);
	}

}
