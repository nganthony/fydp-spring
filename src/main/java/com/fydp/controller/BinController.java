package com.fydp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fydp.domain.Bin;
import com.fydp.service.BinService;
import com.fydp.structure.Envelope;

@Controller
@RequestMapping("bin")
public class BinController {
	
	BinService binService;
	
	@Autowired
	public BinController(BinService binService) {
		this.binService = binService;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public Envelope insertBin(@RequestBody Bin bin) {
		int binId = binService.insertBin(bin);
		return new Envelope(HttpStatus.OK.value(), binService.getBinById(binId));
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public Envelope getBinsBySystemId(@RequestParam int binSystemId) {
		
		List<Bin> bins = binService.getBinsBySystemId(binSystemId);
		return new Envelope(HttpStatus.OK.value(), bins);
	}
}
