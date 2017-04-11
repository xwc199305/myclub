package com.hackathon.jersey.backend.dao;

import java.util.List;

import com.hackathon.jersey.backend.entity.ClubMember;

public interface IClubMemberDao {
	
   public ClubMember getMemberById(long id) throws Exception;
	
	public List<ClubMember> getMembers();

}
