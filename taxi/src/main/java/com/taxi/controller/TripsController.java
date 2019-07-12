package com.taxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taxi.model.Trips;
import com.taxi.pojo.TripReq;
import com.taxi.service.TaxiService;

@RequestMapping("/taxi/trips/")
@RestController
public class TripsController {
	
	@Autowired
	private TaxiService taxiService;
	
	@RequestMapping(value = "/start", method = RequestMethod.POST)

	public Trips createTrip(@Valid @RequestBody TripReq tripReq) throws Exception {
		
		return taxiService.tripStart(tripReq) ;

		
	}
	
	@RequestMapping(value = "/complete", method = RequestMethod.POST)

	public ResponseEntity<byte []> completeTrip(@Valid @RequestBody TripReq tripReq) throws Exception {
		
		return taxiService.tripComplete(tripReq) ;

		
	}
	
	@RequestMapping(value = "/activeTrips", method = RequestMethod.POST)

	public List<Trips> allTrips() throws Exception {
		
		return taxiService.getAllTrips();

		
	}
}
