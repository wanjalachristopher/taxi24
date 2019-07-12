package com.taxi.service;

import java.util.List;

import com.taxi.model.Drivers;
import com.taxi.model.Riders;
import com.taxi.model.Trips;
import com.taxi.pojo.InvoiceObj;
import com.taxi.pojo.Location;
import com.taxi.pojo.TripReq;
import org.springframework.http.ResponseEntity;

public interface TaxiService {
	List<Drivers> getAllDrivers();
	List<Drivers> getAvailableDrivers();
	Drivers getDriver(int id);
	List<Riders> getAllRiders();
	Riders getRider(Long id);
	Trips tripStart(TripReq tripReq);
	ResponseEntity<byte []> tripComplete(TripReq tripReq);
	List<Trips> getAllTrips();
	byte [] getInvoice(InvoiceObj invoiceObj );
	List<Drivers> getDriversCloseBy(Location location);
	List<Drivers> getDriversCloseBySpecific(Double distance);
}
