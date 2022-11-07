package com.cybage.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user_details")
public class User {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(nullable = false)
	private int role;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false,unique=true)
	private String userEmail;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String dob;
	
	@Column(nullable = false)
	private String contactNo;
	
	public String getVerificationCode() {
		return verificationCode;
	}


	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String locked;

	
	@Column(name = "verification_code", length = 64)
	    private String verificationCode;
	     
    private boolean enabled;

//    @Column(name = "account_non_locked")
//    private boolean accountNonLocked;
//     
//    @Column(name = "failed_attempt")
//    private int failedAttempt;
//     
//    @Column(name = "lock_time")
//    private Date lockTime;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


public User(int userId, int role, String userName, String userEmail, String password, String dob, String contactNo,
		String gender, String locked, String verificationCode, boolean enabled) {
	super();
	this.userId = userId;
	this.role = role;
	this.userName = userName;
	this.userEmail = userEmail;
	this.password = password;
	this.dob = dob;
	this.contactNo = contactNo;
	this.gender = gender;
	this.locked = locked;
	this.verificationCode = verificationCode;
	this.enabled = enabled;
}


public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


public int getRole() {
	return role;
}


public void setRole(int role) {
	this.role = role;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getUserEmail() {
	return userEmail;
}


public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getDob() {
	return dob;
}


public void setDob(String dob) {
	this.dob = dob;
}


public String getcontactNo() {
	return contactNo;
}


public void setcontactNo(String contactNo) {
	this.contactNo = contactNo;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getLocked() {
	return locked;
}


public void setLocked(String locked) {
	this.locked = locked;
}


@Override
public String toString() {
	return "User [userId=" + userId + ", role=" + role + ", userName=" + userName + ", userEmail=" + userEmail
			+ ", password=" + password + ", dob=" + dob + ", contactNo=" + contactNo + ", gender=" + gender
			+ ", locked=" + locked + ", verificationCode=" + verificationCode + ", enabled=" + enabled + "]";
}


	
	
	
	
	
	
}