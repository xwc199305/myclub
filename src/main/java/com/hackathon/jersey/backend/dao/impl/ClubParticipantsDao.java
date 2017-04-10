package com.hackathon.jersey.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.hackathon.jersey.backend.dao.IClubParticipantsDao;
import com.hackathon.jersey.backend.entity.ClubActivity;
import com.hackathon.jersey.backend.entity.ClubParticipants;
import com.hackathon.jersey.backend.utils.HibernateSessionUtil;

public class ClubParticipantsDao implements IClubParticipantsDao{

	private final Class<ClubParticipants> entityClass = ClubParticipants.class;
	
	@Override
	public List<ClubParticipants> getParticipants() {
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
	
	

}
