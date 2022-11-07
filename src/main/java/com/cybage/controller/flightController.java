package com.cybage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Flight;
import com.cybage.service.FlightService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/flight")
public class flightController {

	@Autowired
	FlightService flightService;
	
	@GetMapping("/{flightId}")
	public ResponseEntity<?> findById(@PathVariable("flightId") int flightId) {
		Flight flight = flightService.findById(flightId);
		Map<String, Object> map = new HashMap<>();
		map.put("status", "success");
		map.put("data", flight);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Flight> save(@RequestBody Flight flight) {
		flight = flightService.addFlight(flight);
		return ResponseEntity.ok(flight);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Flight>> findAll() {
		List<Flight> list = flightService.getAllFlights();
		return ResponseEntity.ok(list);
		
	}	

	
	@PutMapping("update/{flightId}")
	public ResponseEntity<Flight> update(@PathVariable("flightId") int flightId, @RequestBody Flight flight) {
		flight.setFlightId(flightId);
		Flight modflight = flightService.updateFlight(flight);
		return ResponseEntity.ok(modflight);
	}
	

	@DeleteMapping("deleteflight/{flightId}")
	public ResponseEntity<Boolean> delete(@PathVariable("flightId") int flightId) {
		boolean success = flightService.deleteById(flightId);
		return ResponseEntity.ok(success);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<Boolean> deleteAll() {
		boolean success = flightService.deleteAll();
		return ResponseEntity.ok(success);
	}
}
