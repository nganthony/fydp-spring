package com.fydp.service;

import java.util.List;

import com.fydp.domain.BinData;

public interface BinDataService {

	public void sendData(int binSystemId, int binId, double data, long createdTimestamp);
	
	public List<BinData> getAllData(int binSystemId, int binId);
}
