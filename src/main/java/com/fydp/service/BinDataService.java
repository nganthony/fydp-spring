package com.fydp.service;

import java.util.List;

public interface BinDataService {

	public void sendData(int binSystemId, int binId, double data, long createdTimestamp);
	
	public List<Double> getAllData(int binSystemId, int binId);
}
