package com.hackathon.jersey.backend.dao;

import java.util.List;

import com.hackathon.jersey.backend.entity.ClubActivity;

/**
 * Created At:Mar 30, 2017<br>
 * Copyright © 1995-2017, Oracle and/or its affiliates. All rights reserved.<br>
 * TODO
 * 
 * @author lmTan
 * @version TODO
 */
public interface IClubActivityDao {
	
	public ClubActivity getActivityById(long id) throws Exception;
	
	public List<ClubActivity> getActivities();

	public ClubActivity createActivity(ClubActivity activity);

	public ClubActivity updateActivity(ClubActivity activity);

	public String deleteActivityById(long id) throws Exception;

	public List<ClubActivity> getActivityByName(String name);
	
	
}
