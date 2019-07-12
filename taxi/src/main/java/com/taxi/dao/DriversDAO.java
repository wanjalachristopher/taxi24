package com.taxi.dao;

import java.util.List;

import com.taxi.model.Drivers;

public interface DriversDAO {
 List<Drivers> getAllDrivers();
 List<Drivers> getAvailableDrivers();
 void saveDriver(Drivers driver);
 Drivers getDriver(long driverID);
 void updateDriver(Drivers driver);
 void deleteDriver(Drivers driver);
 List<Drivers> getDriversCloseBy(Double distance,int limit);
}
