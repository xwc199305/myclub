package com.hackathon.jersey.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.hackathon.jersey.backend.dao.IClubMemberDao;
import com.hackathon.jersey.backend.entity.ClubMember;
import com.hackathon.jersey.backend.utils.HibernateSessionUtil;

public class ClubMemberDao implements IClubMemberDao {
	
	private final Class<ClubMember> entityClass = ClubMember.class;
	
	@Override
	public ClubMember getMemberById(long id) throws Exception {
		Session session = HibernateSessionUtil.getSession();
		ClubMember member = (ClubMember) session.get(entityClass, id);
		if (member == null) {
			throw new Exception("resource not found");
		}
	    session.close();
		return member;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClubMember> getMembers() {
		Session session = HibernateSessionUtil.getSession();
		Criteria c = session.createCriteria(entityClass);
		return c.list();
	}
	
	

}
