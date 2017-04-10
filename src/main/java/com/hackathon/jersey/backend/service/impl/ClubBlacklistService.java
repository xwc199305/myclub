package com.hackathon.jersey.backend.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hackathon.jersey.backend.dao.IClubBlacklistDao;
import com.hackathon.jersey.backend.dao.impl.ClubBlacklistDao;
import com.hackathon.jersey.backend.entity.ClubBlacklist;
import com.hackathon.jersey.backend.service.IClubBlacklistService;

@Path("blacklists")
public class ClubBlacklistService implements IClubBlacklistService{
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClubBlacklist createBlacklist(ClubBlacklist blacklist){
		IClubBlacklistDao blacklistDao = new ClubBlacklistDao();
		ClubBlacklist result = blacklistDao.createBlacklist(blacklist);
		if(result!=null){
		    return result;
		}else{
			return null;
		}

		
	}
	
	@DELETE
	@Path("/delete/{id}")
	
    public String deleteBlacklist(@PathParam("id") long id){
		IClubBlacklistDao blacklistDao = new ClubBlacklistDao();
		String result;
		try {
			result = blacklistDao.deleteBlacklistById(id);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
			
	}

}
