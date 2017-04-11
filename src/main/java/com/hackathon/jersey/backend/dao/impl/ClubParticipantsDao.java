package com.hackathon.jersey.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hackathon.jersey.backend.dao.IClubParticipantsDao;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hackathon.jersey.backend.dao.IClubParticipantsDao#
	 * createClubParticipants()
	 */
	@Override
	public ClubParticipants createClubParticipants(ClubParticipants participants) {
		try {
			Session session = HibernateSessionUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(participants);
			transaction.commit();
			session.close();
			return participants;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int deleteParticipantsById(long activityId, long memberId) {
		try {
			int deleteNum = 0;
			Session session = HibernateSessionUtil.getSession();
			Transaction transaction = session.beginTransaction();
// 			String hqlSelect = "select cp from clubParticipants cp where cp.activity_info_id = :activityId and cp.member_info_id = :memberId";
			String hqlDelete = "delete from clubParticipants cp where cp.activity_info_id = :activityId and cp.member_info_id = :memberId";
// 			ClubParticipants participants = (ClubParticipants) session.createQuery(hqlSelect).setParameter("activityId", activityId).setParameter("memberId", memberId).uniqueResult();
// 			if(participants != null){
			deleteNum = session.createQuery(hqlDelete).setParameter("activityId", activityId).setParameter("memberId", memberId).executeUpdate();
// 			}		
			transaction.commit();
			session.close();
			return deleteNum;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	

}
