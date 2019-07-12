package com.taxi.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taxi.dao.DriversDAO;
import com.taxi.dao.RidersDAO;
import com.taxi.dao.TripsDAO;
import com.taxi.model.Drivers;
import com.taxi.model.Riders;
import com.taxi.model.Trips;
import com.taxi.pojo.InvoiceObj;
import com.taxi.pojo.Location;
import com.taxi.pojo.TripReq;
import com.taxi.service.TaxiService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class TaxiServiceImpl implements TaxiService {

private static final Log LOG = LogFactory.getLog(TaxiService.class);

	
@Autowired
private DriversDAO driversDAO;

@Autowired
private RidersDAO ridersDAO;

@Autowired
private TripsDAO tripsDAO;

@Override
public List<Drivers> getAllDrivers() {

	return driversDAO.getAllDrivers();
}

@Override
public List<Drivers> getAvailableDrivers() {
	
	return driversDAO.getAvailableDrivers();
}


@Override
public Drivers getDriver(int id) {
	
	return driversDAO.getDriver(id);
}

@Override
public List<Riders> getAllRiders() {
	
	return ridersDAO.getAllRiders();
}

@Override
public Trips tripStart(TripReq tripReq) {
	Long id;
	Trips trip = new Trips();
	Drivers driver ;
	id = tripsDAO.getMaxId();
	if(id ==null){
		id=0l;
	}
	id++;
	trip.setId(id);
	trip.setDriverId(tripReq.getDriverId());
	trip.setRiderId(tripReq.getRiderId());
	trip.setStatus(1);
	trip.setDateStart(new Date());
	trip.setDateEnd(new Date());
	tripsDAO.insertTrip(trip);
	
	//set driver to 1 (engaged)
	driver = driversDAO.getDriver(trip.getDriverId());
	driver.setStatus(1);
	driversDAO.updateDriver(driver);
	
	return trip;
}

@Override
public ResponseEntity<byte []> tripComplete(TripReq tripReq) {
	Trips trip = tripsDAO.getTrip(tripReq.getDriverId(), tripReq.getRiderId());
	InvoiceObj invoiceObj = new InvoiceObj();
	SimpleDateFormat form =new SimpleDateFormat("yyyy-MM-dd");
	Double price = 4.0;
	String driversName="";
	Drivers driver ;
	Riders rider;
	Random ran = new Random();
	trip.setStatus(0);
	trip.setDateEnd(new Date());
	tripsDAO.updateTrip(trip);
	
	rider = ridersDAO.getRider(trip.getRiderId());
	rider.setGISX(Double.valueOf(ran.nextInt(5)));
	rider.setGISY(Double.valueOf(ran.nextInt(6)));
	
	ridersDAO.updateRider(rider);
	driver = driversDAO.getDriver(trip.getDriverId());
	driversName = driver.getName();
	driver.setStatus(0);
	driver.setGISX(Double.valueOf(ran.nextInt(5)));
	driver.setGISY(Double.valueOf(ran.nextInt(6)));
	
	driversDAO.updateDriver(driver);
	
	
	
	long difference = trip.getDateEnd().getTime() - trip.getDateStart().getTime();
	
	invoiceObj.setAmt(price*difference/1000);
	invoiceObj.setDriverName(driversName);
	
	invoiceObj.setInvoiceNo(String.valueOf(ran.nextInt(1000)));
	
	invoiceObj.setTime(form.format(trip.getDateStart()));
	
	final HttpHeaders headers = new HttpHeaders();
	final String headerKey = "Content-Disposition";
	final String headerValue = "attachment; filename=invoice.pdf";

	headers.set(headerKey, headerValue);
	
	return ResponseEntity.ok().headers(headers)
			.contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(getInvoice(invoiceObj));
	

}

@Override
public List<Trips> getAllTrips() {
	
	return tripsDAO.getAllActiveTrips();
}

@Override
public Riders getRider(Long id) {
	
	return ridersDAO.getRider(id);
}

public byte[] getInvoice(InvoiceObj invoiceObj){
	
	InputStream reportStream = null;
	final ClassLoader classLoader = getClass().getClassLoader();
	String reportTemplateUrl = "invoice.jasper";
	JasperReport jasperReport = null;
	List<InvoiceObj> invoiceDets = new ArrayList<InvoiceObj>();
	byte[] invoiceByte=null;
	try{
	invoiceDets.add(invoiceObj);	

	final File file = new File(classLoader.getResource(reportTemplateUrl).getFile());
	reportStream = new FileInputStream(file);
	jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
	
	final JRBeanCollectionDataSource jRdataSource = new JRBeanCollectionDataSource(invoiceDets);

	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jRdataSource);

	

	invoiceByte = JasperExportManager.exportReportToPdf(jasperPrint);
	
	}
	catch(Exception e){
		LOG.debug("Error: " + e);		
	}

	return invoiceByte;
	
}

@Override
public List<Drivers> getDriversCloseBy(Location location) {
	Riders rider = ridersDAO.getRider(location.getId());
	
	Double diff = rider.getGISY() - rider.getGISX();//Not correct way to calculate distance between gps coordinates
	if(diff<0){
		diff = diff*-1;
	}
	return driversDAO.getDriversCloseBy(diff,3);	
}

@Override
public List<Drivers> getDriversCloseBySpecific(Double distance) {
	
	return driversDAO.getDriversCloseBy(distance,0);
}
}