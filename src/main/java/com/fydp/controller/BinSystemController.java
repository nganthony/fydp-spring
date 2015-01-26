package com.fydp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fydp.domain.BinSystem;
import com.fydp.service.BinSystemService;
import com.fydp.structure.Envelope;

@Controller
@RequestMapping("bin_system")
public class BinSystemController {

	private BinSystemService binSystemService;
	
	@Autowired
	public BinSystemController(BinSystemService binSystemService) {
		this.binSystemService = binSystemService;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public Envelope insertBinSystem(@RequestBody BinSystem binSystem) {
		
		int binSystemId = binSystemService.insertBinSystem(binSystem);
		return new Envelope(HttpStatus.OK.value(), binSystemService.getBinSystemById(binSystemId));
	}
}
