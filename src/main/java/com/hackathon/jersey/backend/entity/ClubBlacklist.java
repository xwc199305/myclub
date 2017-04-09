package com.hackathon.jersey.backend.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity(name = "clubBlacklist")
@Table(name = "myclub_member_blacklist")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClubBlacklist {

	private static final long serialVersionUID = -5170858270896206896L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "MEMBER_INFO_ID", length = 64)
	private long member_info_id;

	@Column(name = "USER_NAME", length = 64)
	private String user_name;

	@Column(name = "CREATE_AT")
	private Timestamp create_at;

	@Column(name = "CREATE_BY", length = 64)
	private String create_by;

	@Column(name = "UPDATE_AT")
	private Timestamp update_at;

	@Column(name = "UPDATE_BY", length = 64)
	private String update_by;

	@Column(name = "DELETED", length = 1)
	private String deleted;

	@Column(name = "CLUB_INFO_ID", length = 64)
	private String club_info_id;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getMember_info_id() {
		return member_info_id;
	}

	public void setMember_info_id(Long member_info_id) {
		this.member_info_id = member_info_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public java.sql.Timestamp getCreate_at() {
		return create_at;
	}

	public void setCreate_at(java.sql.Timestamp create_at) {
		this.create_at = create_at;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public java.sql.Timestamp getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(java.sql.Timestamp update_at) {
		this.update_at = update_at;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getClub_info_id() {
		return club_info_id;
	}

	public void setClub_info_id(String club_info_id) {
		this.club_info_id = club_info_id;
	}
}
