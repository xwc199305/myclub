package com.hackathon.jersey.backend.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hackathon.jersey.backend.dao.IClubBlacklistDao;
import com.hackathon.jersey.backend.entity.ClubBlacklist;
import com.hackathon.jersey.backend.utils.HibernateSessionUtil;

public class ClubBlacklistDao implements IClubBlacklistDao {

	private final Class<ClubBlacklist> entityClass = ClubBlacklist.class;
	
	@Override
	public ClubBlacklist createBlacklist(ClubBlacklist blacklist) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateSessionUtil.getSession();
			Transaction tran = session.beginTransaction();
			session.save(blacklist);
			tran.commit();
		    session.close();

			return blacklist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteBlacklistById(long id) throws Exception{
		// TODO Auto-generated method stub
		Session session = HibernateSessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		ClubBlacklist blacklist;
		
			blacklist = getBlacklistById(id);
			if(blacklist==null){
				return "resource not found";
			}
		    session.delete(blacklist);
		    tran.commit();	
		    session.close();
		
		
	    
	    return "success";
	}

	@Override
	public ClubBlacklist getBlacklistById(long id) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionUtil.getSession();
		ClubBlacklist blacklist = (ClubBlacklist) session.get(entityClass, id);
		if (blacklist == null) {
			throw new Exception("resource not found");
		}
	    session.close();

		return blacklist;
	}

}
