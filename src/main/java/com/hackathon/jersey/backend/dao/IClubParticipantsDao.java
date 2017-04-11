package com.hackathon.jersey.backend.dao;

import java.util.List;

import com.hackathon.jersey.backend.entity.ClubParticipants;

public interface IClubParticipantsDao {

	public List<ClubParticipants> getParticipants();
	
	public ClubParticipants createClubParticipants(ClubParticipants participants);

	public int deleteParticipantsById(long activityId, long memberId);
}
