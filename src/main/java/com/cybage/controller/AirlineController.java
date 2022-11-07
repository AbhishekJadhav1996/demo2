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

import com.cybage.model.Airline;
import com.cybage.model.Flight;
import com.cybage.service.AirlineService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/airline")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	
	@GetMapping("/{airlineId}")
	public ResponseEntity<?> findAirlineById(@PathVariable("airlineId") int airlineId) {
//		Logger logger=org.slf4j.LoggerFactory.getLogger(AirlineController.class);
		Airline airline = airlineService.findAirlineById(airlineId);
		Map<String, Object> map = new HashMap<>();
		map.put("status", "success");
		map.put("data", airline);
		return ResponseEntity.ok(map);
	}
	
	
	@PostMapping("/addairline")
	public ResponseEntity<Airline> save(@RequestBody Airline airline) {
		airline = airlineService.addAirline(airline);
		return ResponseEntity.ok(airline);
		
	}
	
	@GetMapping("/allAirlines")
	public ResponseEntity<List<Airline>> findAll() {
		List<Airline> list = airlineService.getAllAirlines();
		return ResponseEntity.ok(list);
		
	}
	
	@PutMapping("updateairline/{airlineId}")
	public ResponseEntity<Airline> update(@PathVariable("airlineId") int airlineId, @RequestBody Airline airline) {
		airline.setAirlineId(airlineId);
		Airline modAirline = airlineService.updateAirline(airline);
		return ResponseEntity.ok(modAirline);
	}
	

	@DeleteMapping("deleteAirline/{airlineId}")
	public ResponseEntity<Boolean> delete(@PathVariable("airlineId") int airlineId) {
		boolean success = airlineService.deleteAirlineById(airlineId);
		return ResponseEntity.ok(success);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<Boolean> deleteAll() {
		boolean success = airlineService.deleteAll();
		return ResponseEntity.ok(success);
	}
}
