package com.hackathon.jersey.backend.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hackathon.jersey.backend.dao.IClubActivityDao;
import com.hackathon.jersey.backend.dao.impl.ClubActivityDao;
import com.hackathon.jersey.backend.entity.ClubActivity;
import com.hackathon.jersey.backend.entity.ResponseObject;
import com.hackathon.jersey.backend.service.IClubActivityService;
import com.hackathon.jersey.backend.utils.ResponseObjectFactory;

/**
 * Created At:Apr 6, 2017<br>
 * Copyright © 1995-2017, Oracle and/or its affiliates. All rights reserved.<br>
 * TODO
 * 
 * @author lmTan
 * @version TODO
 */
@Path("activities")
public class ClubActivityService implements IClubActivityService {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getActivityById(@PathParam("id") long id) {
		try {
			IClubActivityDao activityDao = new ClubActivityDao();
			ClubActivity activity = activityDao.getActivityById(id);
			
			return JSON.toJSONString(activity, SerializerFeature.DisableCircularReferenceDetect);
		} catch (Exception e) {
			ResponseObject responseObj = ResponseObjectFactory.getFailedObject();
			responseObj.setErrorMessage(e.getMessage());
			return responseObj.toJson();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getActivities() {
		try{
			IClubActivityDao activityDao = new ClubActivityDao();
			List<ClubActivity> activities = activityDao.getActivities();
			ResponseObject responseObj = ResponseObjectFactory.getSuccessObject();
			responseObj.setData(activities);
			return responseObj.toJson();
		}catch(Exception e){
			ResponseObject responseObj = ResponseObjectFactory.getFailedObject();
			responseObj.setErrorMessage("operation failed");
			return responseObj.toJson();
		}
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public ClubActivity createActivity(ClubActivity activity){
		IClubActivityDao activityDao = new ClubActivityDao();
		ClubActivity result = activityDao.createActivity(activity);
		if(result!=null){
		    return result;
		}else{
			return null;
		}

		
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public ClubActivity updateActivity(ClubActivity activity){
		IClubActivityDao activityDao = new ClubActivityDao();
		ClubActivity result = activityDao.updateActivity(activity);
		if(result!=null){
		    return result;
		}else{
			return null;
		}		
	}
	
	@DELETE
	@Path("/delete/{id}")
	
    public String deleteActivity(@PathParam("id") long id){
		IClubActivityDao activityDao = new ClubActivityDao();
		String result;
		try {
			result = activityDao.deleteActivityById(id);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
			
	}
}
