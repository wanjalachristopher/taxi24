package com.taxi.config.init;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.taxi.dao.DriversDAO;
import com.taxi.dao.RidersDAO;
import com.taxi.exceptions.DataBaseException;
import com.taxi.model.Drivers;
import com.taxi.model.Riders;

@Component
public class DbUtils {

	@Autowired
	DriversDAO driversDAO;

	@Autowired
	RidersDAO ridersDAO;

	@PostConstruct
	public void initialize() throws DataBaseException {

		try {
			Drivers driver = new Drivers();
			Riders rider = new Riders();

			driver.setGISX(4.0);
			driver.setGISY(1.0);
			driver.setId(1l);
			driver.setStatus(0);
			driver.setName("Driver 1");
			driversDAO.saveDriver(driver);

			driver.setGISX(4.0);
			driver.setGISY(2.0);
			driver.setId(2l);
			driver.setStatus(0);
			driver.setName("Driver 2");
			driversDAO.saveDriver(driver);
			
			driver.setGISX(5.0);
			driver.setGISY(2.0);
			driver.setId(3l);
			driver.setStatus(0);
			driver.setName("Driver 3");
			driversDAO.saveDriver(driver);
			
			driver.setGISX(6.0);
			driver.setGISY(2.0);
			driver.setId(4l);
			driver.setStatus(0);
			driver.setName("Driver 4");
			driversDAO.saveDriver(driver);
			
			driver.setGISX(7.0);
			driver.setGISY(1.0);
			driver.setId(5l);
			driver.setStatus(0);
			driver.setName("Driver 5");
			driversDAO.saveDriver(driver);
			
			driver.setGISX(1.0);
			driver.setGISY(1.0);
			driver.setId(6l);
			driver.setStatus(0);
			driver.setName("Driver 6");
			driversDAO.saveDriver(driver);

			rider.setGISX(4.0);
			rider.setGISY(2.0);
			rider.setId(1l);
			rider.setName("Rider 1");
			ridersDAO.saveRider(rider);

			rider.setGISX(4.0);
			rider.setGISY(1.0);
			rider.setId(2l);
			rider.setName("Rider 2");
			ridersDAO.saveRider(rider);
			
			rider.setGISX(5.0);
			rider.setGISY(2.0);
			rider.setId(3l);
			rider.setName("Rider 3");
			ridersDAO.saveRider(rider);
			
			rider.setGISX(6.0);
			rider.setGISY(2.0);
			rider.setId(4l);
			rider.setName("Rider 4");
			ridersDAO.saveRider(rider);

		} catch (Exception e) {
			throw new DataBaseException();
		}

	}

}
