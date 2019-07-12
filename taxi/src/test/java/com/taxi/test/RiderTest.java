package com.taxi.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taxi.dao.RidersDAO;

public class RiderTest {
	@Autowired
	private static RidersDAO ridersDAO;
	
	
	
	@Test
	public void searchRider(){
		
		try {
			ridersDAO.getRider(1l);
			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}
		
		
		
	}
	@Test
	public void searchRiders(){
		
		try {
			ridersDAO.getAllRiders();
			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}	
		
		
	}
	
}
