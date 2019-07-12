package com.taxi.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.taxi.dao.TripsDAO;
import com.taxi.model.Trips;

@Repository
@Transactional(readOnly=true)
public class TripsDAOImpl implements TripsDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(readOnly=false,rollbackFor = Exception.class)
	public void insertTrip(Trips trip) {
		
        
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(trip);
		tx.commit();
		
		
	}

	@Override
	@Transactional(readOnly=false,rollbackFor = Exception.class)
	public void updateTrip(Trips trip) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(trip);
		tx.commit();
	}

	@Override
	public List<Trips> getAllActiveTrips() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Trips where status=1";
		Query query = session.createQuery(hql);
		List<Trips> trips = query.list();
		return trips;
	}

	@Override
	public Long getMaxId() {
		Session session = sessionFactory.openSession();
		String hql = "select max(t.id) FROM Trips t";
		Query query = session.createQuery(hql);
		return (Long)query.uniqueResult();
	}

	@Override
	public Trips getTrip(long driverID, long riderID) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Trips t where t.driverId=:driverID and t.riderId=:riderID and  t.status=1";
		Query query = session.createQuery(hql).setParameter("driverID", driverID).setParameter("riderID", riderID);
		return (Trips)query.uniqueResult();
		
	}

	

	
 
}
