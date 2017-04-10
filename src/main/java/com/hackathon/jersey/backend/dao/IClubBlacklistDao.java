package com.hackathon.jersey.backend.dao;

import com.hackathon.jersey.backend.entity.ClubActivity;
import com.hackathon.jersey.backend.entity.ClubBlacklist;

public interface IClubBlacklistDao {


	public ClubBlacklist createBlacklist(ClubBlacklist blacklist);

	public String deleteBlacklistById(long id) throws Exception;
	
	public ClubBlacklist getBlacklistById(long id) throws Exception;

}
