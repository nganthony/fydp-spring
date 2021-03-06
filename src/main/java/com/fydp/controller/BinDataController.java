package com.fydp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fydp.domain.BinData;
import com.fydp.service.BinDataService;
import com.fydp.structure.Envelope;

@Controller
@RequestMapping("bin_data")
public class BinDataController {
	
	@Autowired 
	BinDataService binDataService;
	
	@RequestMapping(value = "send", method = RequestMethod.POST)
	@ResponseBody
	public Envelope sendData(@RequestParam int binSystemId, 
			@RequestParam int binId, 
			@RequestParam double data,
			@RequestParam long createdTimestamp) {
		
		binDataService.sendData(binSystemId, binId, data, createdTimestamp);
		
		return new Envelope(HttpStatus.OK.value());
	}
	
	@RequestMapping(value = "data", method = RequestMethod.GET)
	@ResponseBody
	public Envelope getBinData(@RequestParam int binSystemId, @RequestParam int binId) {
		
		List<BinData> binDataList = binDataService.getAllData(binSystemId, binId);
		return new Envelope(HttpStatus.OK.value(), binDataList);
	}
}
