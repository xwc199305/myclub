package com.hackathon.jersey.backend.utils;

import com.hackathon.jersey.backend.entity.ResponseObject;

/**
 * Created At:Apr 6, 2017<br>
 * Copyright © 1995-2017, Oracle and/or its affiliates. All rights reserved.<br>
 * TODO
 * 
 * @author lmTan
 * @version TODO
 */
public class ResponseObjectFactory {
	
	private static final String SUCCESS = "success";
	private static final String FAILED = "failed";
	
	public static ResponseObject getSuccessObject(){
		ResponseObject obj = new ResponseObject();
		obj.setStatus(SUCCESS);
		return obj;
	}
	
	public static ResponseObject getFailedObject(){
		ResponseObject obj = new ResponseObject();
		obj.setStatus(FAILED);
		return obj;
	}
}
