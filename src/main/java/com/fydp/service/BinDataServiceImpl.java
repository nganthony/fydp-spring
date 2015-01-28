package com.fydp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fydp.dao.BinDataDao;
import com.fydp.domain.BinData;

@Service
public class BinDataServiceImpl implements BinDataService {

	@Autowired
	BinDataDao binDataDao;
	
	public void sendData(int binSystemId, int binId, double data, long createdTimestamp) {
		binDataDao.insertData(binSystemId, binId, data, createdTimestamp);
	}

	public List<BinData> getAllData(int binSystemId, int binId) {
		return binDataDao.getAllData(binSystemId, binId);
	}

}
