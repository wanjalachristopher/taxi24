package com.taxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.model.Drivers;
import com.taxi.model.Riders;
import com.taxi.pojo.Location;
import com.taxi.pojo.RiderReq;
import com.taxi.service.TaxiService;

@RequestMapping("/taxi/riders/")
@RestController
public class RiderController {

	@Autowired
	private TaxiService taxiService;
	
@RequestMapping(method = RequestMethod.GET)
	
	public List<Riders> getDrivers() throws Exception {
		
		return taxiService.getAllRiders() ;
	
		
	}
@RequestMapping(value = "/rider", method = RequestMethod.POST)

public Riders getDriver(@Valid @RequestBody RiderReq riderReq) throws Exception {
	
	return taxiService.getRider(riderReq.getId()) ;

	
}

@RequestMapping(value = "/driversClose", method = RequestMethod.POST)

public List<Drivers> getClosetDrivers(@Valid @RequestBody Location location) throws Exception {
	
	return taxiService.getDriversCloseBy(location);

	
}

}
