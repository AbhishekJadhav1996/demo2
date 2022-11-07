package com.cybage.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	@Column
	private String feedbackDescription;	
	@Column
	private Timestamp registeredDate;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingId")
    private Booking booking;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(int feedbackId, String feedbackDescription, Timestamp registeredDate, Booking booking) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackDescription = feedbackDescription;
		this.registeredDate = registeredDate;
		this.booking = booking;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackDescription() {
		return feedbackDescription;
	}
	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}
	public Timestamp getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackDescription=" + feedbackDescription
				+ ", registeredDate=" + registeredDate + ", booking=" + booking + "]";
	}
	
	
}
