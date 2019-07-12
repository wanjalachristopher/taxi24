package com.taxi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.dao.RidersDAO;
import com.taxi.model.Riders;

@Repository
@Transactional(readOnly = true)
public class RidersDAOImpl implements RidersDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Riders> getAllRiders() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Riders";
		Query query = session.createQuery(hql);
		List<Riders> riders = query.list();
		return riders;
	}

	@Override
	public Riders getRider(Long id) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Riders where id=:id";
		Query query = session.createQuery(hql).setParameter("id", id);
				
		return (Riders) query.uniqueResult();
	}

	@Override
	public void saveRider(Riders rider) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(rider);
		tx.commit();
	}
	
	@Override
	@Transactional(readOnly=false,rollbackFor = Exception.class)
	public void updateRider(Riders rider) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(rider);
		tx.commit();
	}

	@Override
	public void deleteRider(Riders rider) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(rider);
		tx.commit();
	
		
	}

	
 
}
