package com.cybage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int airlineId;
	@Column
	private String airlineName;
	@Column
	private String airlineNumber;
	
	
	public Airline() {
		// TODO Auto-generated constructor stub
	}

	public Airline(int airlineId, String airlineName, String airlineNumber) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.airlineNumber = airlineNumber;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineNumber() {
		return airlineNumber;
	}

	public void setAirlineNumber(String airlineNumber) {
		this.airlineNumber = airlineNumber;
	}


	
	
}
