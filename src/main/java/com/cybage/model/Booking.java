package com.cybage.model;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@Column
	private Timestamp bookingDateTime;
	@Column
	private String seatClass;
//	@Column
//	private String bookingNumber;
//	@Temporal(TemporalType.DATE)
//	@Column
//	private Date travelDate;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailId;
	@Column
	private String passengerCategory;
	@Column
	private String gender;
	@Column
	private String contactNo;
	@Column
	private String passportNumber;

//	@JsonManagedReference
//	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Passenger> passengers;

	@JsonManagedReference
	@OneToOne(mappedBy = "booking")
	private Complaint complaint;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "flightId")
	private Flight flight;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Booking(int bookingId, Timestamp bookingDateTime, String seatClass, String firstName, String lastName,
			String emailId, String passengerCategory, String gender, String contactNo, String passportNumber,
			Complaint complaint, Flight flight) {
		super();
		this.bookingId = bookingId;
		this.bookingDateTime = bookingDateTime;
		this.seatClass = seatClass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.passengerCategory = passengerCategory;
		this.gender = gender;
		this.contactNo = contactNo;
		this.passportNumber = passportNumber;
		this.complaint = complaint;
		this.flight = flight;
	}



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassengerCategory() {
		return passengerCategory;
	}

	public void setPassengerCategory(String passengerCategory) {
		this.passengerCategory = passengerCategory;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	

	

}