package com.fydp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fydp.dao.BinSystemDao;
import com.fydp.domain.BinSystem;

@Service
public class BinSystemServiceImpl implements BinSystemService {

	@Autowired
	BinSystemDao binSystemDao;

	public int insertBinSystem(BinSystem binSystem) {
		return binSystemDao.insertBinSystem(binSystem);
	}

	public BinSystem getBinSystemById(int id) {
		return binSystemDao.getBinSystemById(id);
	}
	
}
