package com.taxi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.DriversDAO;
import com.taxi.model.Drivers;

@Repository
@Transactional(readOnly=false)
public class DriversDAOImpl implements DriversDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Drivers> getAllDrivers() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Drivers";
		Query query = session.createQuery(hql);
		List<Drivers> drivers = query.list();
		return drivers;
	}

	@Override
	public List<Drivers> getAvailableDrivers() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Drivers where status=0";
		Query query = session.createQuery(hql);
		List<Drivers> drivers = query.list();
		return drivers;
	}

@Override
	public void saveDriver(Drivers driver) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(driver);
		tx.commit();			
		
	}
	
	@Override
	@Transactional(readOnly=false,rollbackFor = Exception.class)
	public void updateDriver(Drivers driver) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(driver);
		tx.commit();
	}
	@Override
	public Drivers getDriver(long driverID) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Drivers d where d.id=:driverID";
		Query query = session.createQuery(hql).setParameter("driverID", driverID);
		
		return (Drivers)query.uniqueResult();
	}

	
	@Override
	public List<Drivers> getDriversCloseBy(Double distance,int limit) {
		Session session = sessionFactory.openSession();
		
		String hql = "";
		Query query ;
		hql = "FROM Drivers where GISX-GISY<=:distance";
		query = session.createQuery(hql).setParameter("distance", distance);
		 if(limit >0){
			 
				query.setMaxResults(limit);
		 
		}
		
		
		List<Drivers> drivers = query.list();
		return drivers;
	}

	@Override
	public void deleteDriver(Drivers driver) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(driver);
		tx.commit();
		
	}
 
}
