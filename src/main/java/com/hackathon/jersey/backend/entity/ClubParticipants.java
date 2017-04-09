package com.hackathon.jersey.backend.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity(name = "clubParticipants")
@Table(name = "myclub_activity_participants")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClubParticipants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ACTIVITY_INFO_ID", length = 64)
	private long activity_info_id;

	@Column(name = "MEMBER_INFO_ID", length = 64)
	private long member_info_id;

	@Column(name = "DELETED", length = 1)
	private String deleted;

	@Column(name = "CREATE_AT")
	private Timestamp create_at;

	@Column(name = "CREATE_BY", length = 64)
	private String create_by;

	@Column(name = "UPDATE_AT")
	private Timestamp updata_at;

	@Column(name = "UPDATE_BY", length = 64)
	private String update_by;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivity_info_id() {
		return activity_info_id;
	}

	public void setActivity_info_id(Long activity_info_id) {
		this.activity_info_id = activity_info_id;
	}

	public Long getMember_info_id() {
		return member_info_id;
	}

	public void setMember_info_id(Long member_info_id) {
		this.member_info_id = member_info_id;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Timestamp getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public java.sql.Timestamp getUpdata_at() {
		return updata_at;
	}

	public void setUpdata_at(java.sql.Timestamp updata_at) {
		this.updata_at = updata_at;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
}
