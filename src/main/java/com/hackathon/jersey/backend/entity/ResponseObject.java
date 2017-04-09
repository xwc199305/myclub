package com.hackathon.jersey.backend.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created At:Apr 6, 2017<br>
 * Copyright © 1995-2017, Oracle and/or its affiliates. All rights reserved.<br>
 * TODO
 * 
 * @author lmTan
 * @version TODO
 */
public class ResponseObject {
	
	private Object data;
	
	@JSONField(name = "status")
	private String status;
	
	@JSONField(name = "errorMsg")
	private String errorMessage;

	public String toJson(){
		return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
