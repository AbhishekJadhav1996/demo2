package com.cybage.dto;

public class UserDto {
private int	userId;
private int role;
private String userName;
private String userEmail;
private String password;
private String dob;
private String contaactNo;
private String gender;
private String locked;
public UserDto(int userId, int role, String userName, String userEmail, String password, String dob, String contaactNo,
		String gender, String locked) {
	super();
	this.userId = userId;
	this.role = role;
	this.userName = userName;
	this.userEmail = userEmail;
	this.password = password;
	this.dob = dob;
	this.contaactNo = contaactNo;
	this.gender = gender;
	this.locked = locked;
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
public String getContaactNo() {
	return contaactNo;
}
public void setContaactNo(String contaactNo) {
	this.contaactNo = contaactNo;
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
	return "UserDto [userId=" + userId + ", role=" + role + ", userName=" + userName + ", userEmail=" + userEmail
			+ ", password=" + password + ", dob=" + dob + ", contaactNo=" + contaactNo + ", gender=" + gender
			+ ", locked=" + locked + "]";
}


}
