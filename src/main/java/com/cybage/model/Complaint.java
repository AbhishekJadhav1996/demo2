package com.cybage.model;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complaintId;

	@Column
	private String complaintDescription;	
	@Column
	private Timestamp registeredDate;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId")
    private Booking booking;
	
	public Complaint() {
		// TODO Auto-generated constructor stub
	}

	public Complaint(int complaintId, String complaintDescription, Timestamp registeredDate, Booking booking) {
		super();
		this.complaintId = complaintId;
		this.complaintDescription = complaintDescription;
		this.registeredDate = registeredDate;
		this.booking = booking;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
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
		return "Complaint [complaintId=" + complaintId + ", complaintDescription=" + complaintDescription
				+ ", registeredDate=" + registeredDate + ", booking=" + booking + "]";
	}



	
	
	
	
}
