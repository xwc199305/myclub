package com.hackathon.jersey.backend.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "clubMember")
@Table(name = "myclub_member_info")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ClubMember {
	
	private static final long serialVersionUID = -5170858270896206896L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "PHONE_NUM", length = 32)
    private String phoneNum;
    
    @Column(name = "EMP_NO", length = 32)
    private String empNo;
    
    @Column(name = "GENDER",length = 1)
    private String gender;
    
    @Column(name = "EMAIL",length=64)
    private String email;
    
    @Column(name = "PASSWORD", length = 32)
    private String password;
    
    @Column(name = "USER_NAME", length = 32)
    private String userName;
    
    @Column(name = "CREATE_AT")
	private Timestamp createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "CREATE_BY", length = 64)
	private String createBy;
	
	@Column(name = "UPDATE_AT")
	private Timestamp updateAt;

	@Column(name = "UPDATE_BY", length = 64)
	private String updateBy;
	
	@Column(name = "DELETED", length = 1)
    private String deleted;
	
	
    
   
    
	

	

}
