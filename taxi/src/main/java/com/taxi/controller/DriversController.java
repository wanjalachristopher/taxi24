package com.taxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.model.Drivers;
import com.taxi.pojo.DriverReq;
import com.taxi.service.TaxiService;

@RequestMapping("/taxi/drivers/")
@RestController
public class DriversController {
	@Autowired
	private TaxiService taxiService;
	
@RequestMapping(method = RequestMethod.GET)
	
	public List<Drivers> getDrivers() {
		
		return taxiService.getAllDrivers() ;
	
		
	}

@RequestMapping(value = "/available", method = RequestMethod.GET)

public List<Drivers> getAvailableDrivers() {
	
	return taxiService.getAvailableDrivers() ;

	
}

@RequestMapping(value = "/driverCloseBySpecific", method = RequestMethod.GET)

public List<Drivers> getDriverCloseBy(@RequestParam(value = "distance") Double distance)  {
	
	return taxiService.getDriversCloseBySpecific(distance) ;

	
}
@RequestMapping(value = "/driver", method = RequestMethod.POST)

public Drivers getDriver(@Valid @RequestBody DriverReq driverReq)  {
	
	return taxiService.getDriver(driverReq.getId()) ;

	
}
}
