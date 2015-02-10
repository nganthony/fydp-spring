package com.fydp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fydp.dao.BinDao;
import com.fydp.domain.Bin;

@Service
public class BinServiceImpl implements BinService {

	@Autowired
	BinDao binDao;
	
	public int insertBin(Bin bin) {
		return binDao.insertBin(bin);
	}

	public Bin getBinById(int id) {
		return binDao.getBinById(id);
	}

	public List<Bin> getBinsBySystemId(int binSystemId) {
		return binDao.getBinsBySystemId(binSystemId);
	}

}
