package com.hackathon.jersey.backend.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created At:Mar 30, 2017<br>
 * Copyright © 1995-2017, Oracle and/or its affiliates. All rights reserved.<br>
 * TODO
 * 
 * @author lmTan
 * @version TODO
 */
@Entity(name = "clubActivity")
@Table(name = "myclub_activity_info")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClubActivity implements Serializable{
	
	private static final long serialVersionUID = -5170858270896206896L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "NAME", length = 64)
    private String name;
    
    @Column(name = "DESCRIPTION", length = 256)
    private String description;
    
    @Column(name = "ACTIVITY_START_TIME")
    private Timestamp activity_start_time;
    
    @Column(name = "ACTIVITY_END_TIME")
    private Timestamp activity_end_time;
    
    @Column(name = "LOCATION", length = 64)
    private String location;
    
    @Column(name = "PUBLISHED", length = 1)
    private String published;
    
    @Column(name = "DELETED", length = 1)
    private String deleted;
    
    @Column(name = "AVAILABLE_NUM")
    private int availableNum;
    
    @Column(name = "ENROLL_NUM")
    private int enrollNum;
    
    @Column(name = "CLUB_ID", length = 64)
    private String clubId;
    
	@Column(name = "CREATE_AT")
	private Timestamp createAt;

	@Column(name = "CREATE_BY", length = 64)
	private String createBy;

	@Column(name = "UPDATE_AT")
	private Timestamp updateAt;

	@Column(name = "UPDATE_BY", length = 64)
	private String updateBy;

	//getter and setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getActivity_start_time() {
		return activity_start_time;
	}

	public void setActivity_start_time(Timestamp activity_start_time) {
		this.activity_start_time = activity_start_time;
	}

	public Timestamp getActivity_end_time() {
		return activity_end_time;
	}

	public void setActivity_end_time(Timestamp activity_end_time) {
		this.activity_end_time = activity_end_time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getAvailableNum() {
		return availableNum;
	}

	public void setAvailableNum(int availableNum) {
		this.availableNum = availableNum;
	}

	public int getEnrollNum() {
		return enrollNum;
	}

	public void setEnrollNum(int enrollNum) {
		this.enrollNum = enrollNum;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
