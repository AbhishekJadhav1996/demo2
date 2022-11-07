package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.FlightDao;
import com.cybage.model.Flight;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FlightService {
	@Autowired
	private FlightDao flightDao;

	public Flight addFlight(Flight flight) {
		return flightDao.save(flight);
	}

	public List<Flight> getAllFlights() {
		List<Flight> flights = new ArrayList<Flight>();
		flightDao.findAll().forEach(flight1 -> flights.add(flight1));
		return flights;
	}

	public Flight updateFlight(Flight flight) {
		return flightDao.save(flight);
	}

	public boolean deleteById(int flightId) {
		if (flightDao.existsById(flightId)) {
			flightDao.deleteById(flightId);
			return true;
		}
		return false;
	}

	public Flight findById(int id) {
		Optional<Flight> flight = flightDao.findById(id);
		return flight.orElse(null);
	}
	
	public boolean deleteAll() {
		flightDao.deleteAll();
		return false;
	}
}
