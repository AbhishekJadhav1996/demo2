package com.cybage.model;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "flight")
public class Flight {
	@Id @GeneratedValue(strategy= GenerationType.AUTO
		    )
	private int flightId;
	
	@Column
	private String flightName;
	@Temporal(TemporalType.DATE)
	@Column
	private Date flightTravelDate;
	@Column
	private String departureTime;
	
	@Column
	private String source;
	
	@Column
	private String destination;

	@Column
	private double fare;
	@Column
	private int seatingCapacity;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY,mappedBy="flight")
	private List<Booking> bookings;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_Id")
	private Airline airline;
	


	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(int flightId, String flightName, Date flightTravelDate, String departureTime, String source,
			String destination, double fare, int seatingCapacity, List<Booking> bookings, Airline airline) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightTravelDate = flightTravelDate;
		this.departureTime = departureTime;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.seatingCapacity = seatingCapacity;
		this.bookings = bookings;
		this.airline = airline;
	}







	public int getFlightId() {
		return flightId;
	}



	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}



	public String getFlightName() {
		return flightName;
	}



	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}



	public Date getFlightTravelDate() {
		return flightTravelDate;
	}



	public void setFlightTravelDate(Date flightTravelDate) {
		this.flightTravelDate = flightTravelDate;
	}



	public String getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}





	public double getFare() {
		return fare;
	}



	public void setFare(double fare) {
		this.fare = fare;
	}



	public int getSeatingCapacity() {
		return seatingCapacity;
	}



	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}



	public List<Booking> getBookings() {
		return bookings;
	}



	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}



	public Airline getAirline() {
		return airline;
	}



	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	
}
