package com.cybage.model;

public class otpCredentials {

	private String email;
	private int otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public otpCredentials(String email, int otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	public otpCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "otpCredentials [email=" + email + ", otp=" + otp + "]";
	}
	
	
	
	
	
}
