package com.taxi.dao;

import java.util.List;

import com.taxi.model.Trips;

public interface TripsDAO {
	public void insertTrip (Trips trip);
	public void updateTrip (Trips trip);
	List<Trips> getAllActiveTrips();
	Long getMaxId();
	Trips getTrip(long driverID,long riderID);
	
}
