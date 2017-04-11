package com.hackathon.jersey.backend.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hackathon.jersey.backend.dao.IClubActivityDao;
import com.hackathon.jersey.backend.dao.IClubMemberDao;
import com.hackathon.jersey.backend.dao.IClubParticipantsDao;
import com.hackathon.jersey.backend.dao.impl.ClubActivityDao;
import com.hackathon.jersey.backend.dao.impl.ClubMemberDao;
import com.hackathon.jersey.backend.dao.impl.ClubParticipantsDao;
import com.hackathon.jersey.backend.entity.ClubActivity;
import com.hackathon.jersey.backend.entity.ClubMember;
import com.hackathon.jersey.backend.entity.ClubParticipants;
import com.hackathon.jersey.backend.entity.ResponseObject;
import com.hackathon.jersey.backend.service.IClubMemberService;
import com.hackathon.jersey.backend.utils.DateUtils;
import com.hackathon.jersey.backend.utils.ResponseObjectFactory;

@Path("members")
public class ClubMemberService implements IClubMemberService {
	public static final String SUCCESS = "success";
	public static final String Fail = "fail";
	public static final String ERROR = "error";
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//	@Path("/create/?activityId={activityId}&memberId={memberId}")
	public String enrollActivity(@QueryParam("activityId")long activityId, @QueryParam("memberId")long memberId) {
		IClubParticipantsDao clubParticipantsDao = new ClubParticipantsDao();
		IClubActivityDao clubActivityDao = new ClubActivityDao();
		IClubMemberDao clubMemberDao = new ClubMemberDao();
		ClubParticipants participants = new ClubParticipants();
		ClubParticipants returnParticipant;
		ClubMember member;
		ClubActivity activity;
		try {
			activity = clubActivityDao.getActivityById(activityId);
			member = clubMemberDao.getMemberById(memberId);
			participants.setActivity_info_id(activity.getId());
			participants.setMember_info_id(member.getId());
			participants.setDeleted("N");
			participants.setCreate_by(member.getUserName());
			participants.setCreate_at(DateUtils.getCurrTimestamp());
			returnParticipant = clubParticipantsDao.createClubParticipants(participants);
			ResponseObject responseObj = null;
			if(returnParticipant != null){
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
