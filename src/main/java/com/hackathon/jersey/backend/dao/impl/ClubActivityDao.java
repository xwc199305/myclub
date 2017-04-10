package com.hackathon.jersey.backend.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hackathon.jersey.backend.dao.IClubActivityDao;
import com.hackathon.jersey.backend.entity.ClubActivity;
import com.hackathon.jersey.backend.utils.HibernateSessionUtil;

/**
 * Created At:Mar 30, 2017<br>
 * Copyright © 1995-2017, Oracle and/or its affiliates. All rights reserved.<br>
 * TODO
 * 
 * @author lmTan
 * @version TODO
 */
public class ClubActivityDao implements IClubActivityDao {

	private final Class<ClubActivity> entityClass = ClubActivity.class;

	@PersistenceContext(unitName = "demoRestPersistence")
	private EntityManager entityManager;

	public ClubActivity getActivityById(long id) throws Exception {
		Session session = HibernateSessionUtil.getSession();
		ClubActivity activity = (ClubActivity) session.get(entityClass, id);
		if (activity == null) {
			throw new Exception("resource not found");
		}
	    session.close();

		return activity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hackathon.jersey.backend.dao.IClubActivityDao#getActivities()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClubActivity> getActivities() {
		Session session = HibernateSessionUtil.getSession();
//		String hql = "select id, name from clubActivity";
//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery(hql);
		Criteria c = session.createCriteria(entityClass);
//		c.add(Restrictions.eq("deleted", "N"));
//		c.add(Restrictions.eq("published", "Y"));
//		c.addOrder(Order.desc("activity_start_time"));
//		tx.commit();
	    

		return c.list();
	}

	@Override
	public ClubActivity createActivity(ClubActivity activity) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionUtil.getSession();
			Transaction tran = session.beginTransaction();
			session.save(activity);
			tran.commit();
		    session.close();

			return activity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ClubActivity updateActivity(ClubActivity activity) {
		// TODO Auto-generated method stub
		try{
			Session session = HibernateSessionUtil.getSession();
			Transaction tran = session.beginTransaction();
			session.update(activity);
			tran.commit();
			session.close();
			return activity;
		}catch(Exception e){
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public String deleteActivityById(long id) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		ClubActivity activity = getActivityById(id);	
		if(activity==null){
			return "resource not found";
		}
	    session.delete(activity);
	    tran.commit();	
	    session.close();
	    
	    return "success";
		 
			
		
		
		
	}

}
