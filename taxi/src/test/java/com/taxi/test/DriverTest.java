package com.taxi.test;

import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.DriversDAO;

public class DriverTest {
	
	
	@Autowired
	DriversDAO driversDAO;
	
	
	
	@Test
	public void searchDriver(){
		
		try {
			driversDAO.getDriver(11);
			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}
		
		
		
	}
	/*@Test*/
	public void searchDrivers(){
		
		try {
			driversDAO.getAllDrivers();
			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}	
		
		
	}
}
