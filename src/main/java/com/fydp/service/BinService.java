package com.fydp.service;

import java.util.List;

import com.fydp.domain.Bin;

public interface BinService {

	public int insertBin(Bin bin);
	public Bin getBinById(int id);
	public List<Bin> getBinsBySystemId(int binSystemId);
	public void updateCurrentMass(int binSystemId, int binId, double data);
}
