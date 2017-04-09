package com.hackathon.jersey.backend.utils;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hackathon.jersey.backend.service.impl.ClubActivityService;
public class MyServiceRegister extends ResourceConfig {
	
	public MyServiceRegister() {  
        //转换格式资源类  
        register(JacksonJsonProvider.class);  
        //web service接口类  
        register(ClubActivityService.class);  
    }  

}
