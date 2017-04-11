package com.hackathon.jersey.backend.service.impl;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hackathon.jersey.backend.dao.IClubParticipantsDao;
import com.hackathon.jersey.backend.dao.impl.ClubParticipantsDao;
import com.hackathon.jersey.backend.entity.ClubParticipants;
import com.hackathon.jersey.backend.entity.ResponseObject;
import com.hackathon.jersey.backend.service.IClubParticipantsService;
import com.hackathon.jersey.backend.utils.ResponseObjectFactory;


@Path("participants")
public class ClubParticipantsService implements IClubParticipantsService{
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
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
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Path("/delete/?activityId={activityId}&memberId={memberId}")
	public String deleteParticipant(@QueryParam("activityId")long activityId, @QueryParam("memberId")long memberId){
		IClubParticipantsDao clubParticipantsDao = new ClubParticipantsDao();
		int deleteNum = 0;
		try {
			deleteNum = clubParticipantsDao.deleteParticipantsById(activityId, memberId);
			ResponseObject responseObj = null;
			if(deleteNum != 0){
				responseObj = ResponseObjectFactory.getSuccessObject();
				return responseObj.toJson();
			}
			responseObj = ResponseObjectFactory.getFailedObject();
			return responseObj.toJson();
		} catch (Exception e) {
			ResponseObject responseObj = ResponseObjectFactory.getFailedObject();
			responseObj.setErrorMessage(e.getMessage());
			return responseObj.toJson();
		}
	}

}
