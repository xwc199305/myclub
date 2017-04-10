package com.hackathon.jersey.backend.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hackathon.jersey.backend.dao.IClubActivityDao;
import com.hackathon.jersey.backend.dao.IClubBlacklistDao;
import com.hackathon.jersey.backend.dao.IClubParticipantsDao;
import com.hackathon.jersey.backend.dao.impl.ClubActivityDao;
import com.hackathon.jersey.backend.dao.impl.ClubParticipantsDao;
import com.hackathon.jersey.backend.entity.ClubActivity;
import com.hackathon.jersey.backend.entity.ClubParticipants;
import com.hackathon.jersey.backend.entity.ResponseObject;
import com.hackathon.jersey.backend.service.IClubParticipantsService;
import com.hackathon.jersey.backend.utils.ResponseObjectFactory;


@Path("participants")
public class ClubParticipantsService implements IClubParticipantsService{
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getParticipants() {
		try{
			IClubParticipantsDao participantsDao = new ClubParticipantsDao();
			List<ClubParticipants> participants = participantsDao.getParticipants();
			
			return JSON.toJSONString(participants, SerializerFeature.DisableCircularReferenceDetect);
//			ResponseObject responseObj = ResponseObjectFactory.getSuccessObject();
//			responseObj.setData(activities);
//			return responseObj.toJson();
		}catch(Exception e){
			e.printStackTrace();
			ResponseObject responseObj = ResponseObjectFactory.getFailedObject();
			responseObj.setErrorMessage("operation failed");
			return responseObj.toJson();
		}
	}

}
