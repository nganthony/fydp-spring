package com.fydp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fydp.service.BinDataService;
import com.fydp.structure.Envelope;
import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.Line;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Shape;

@Controller
@RequestMapping("bin")
public class BinController {
	
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
	public String getBinData(@RequestParam int binSystemId, 
			@RequestParam int binId, ModelMap model) {
		
		List<Double> data = binDataService.getAllData(binSystemId, binId);
		
		Line line1 = Plots.newLine(Data.newData(data), Color.newColor("CA3D05"), "Bin data");
		line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.DIAMOND, Color.newColor("CA3D05"), 12);
        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 8);
        
        // Defining chart.
        LineChart chart = GCharts.newLineChart(line1);
        chart.setSize(600, 450);
        chart.setTitle("Bin data", Color.WHITE, 14);
        chart.setGrid(25, 25, 3, 2);
        
        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.WHITE, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis2 = AxisLabelsFactory.newAxisLabels("Mass (g)", 50.0);
        yAxis2.setAxisStyle(AxisStyle.newAxisStyle(Color.WHITE, 14, AxisTextAlignment.CENTER));
        yAxis2.setAxisStyle(axisStyle);
        
        chart.addYAxisLabels(yAxis2);
        
        // Defining background and chart fills.
        chart.setBackgroundFill(Fills.newSolidFill(Color.newColor("1F1D1D")));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.newColor("363433"), 100);
        fill.addColorAndOffset(Color.newColor("2E2B2A"), 0);
        chart.setAreaFill(fill);
		
		model.addAttribute("pieUrl", chart.toURLString());
		
		return "GPieChart";
		
	}
}
