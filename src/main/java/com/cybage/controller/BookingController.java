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

import com.cybage.model.Booking;
import com.cybage.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {

		@Autowired
		BookingService bookingService;
		
		@GetMapping("/{bookingId}")
		public ResponseEntity<?> findById(@PathVariable("bookingId") int bookingId) {
			Booking booking = bookingService.findById(bookingId);
			Map<String, Object> map = new HashMap<>();
			map.put("status", "success");
			map.put("data", booking);
			return ResponseEntity.ok(map);
		}
		
		@PostMapping("/add")
		public ResponseEntity<Booking> save(@RequestBody Booking booking) {
			booking = bookingService.addBooking(booking);
			return ResponseEntity.ok(booking);
		}
		
		@GetMapping("/all")
		public ResponseEntity<List<Booking>> findAll() {
			List<Booking> list = bookingService.getAllBookings();
			return ResponseEntity.ok(list);
			
		}	

		
		@PutMapping("update/{bookingId}")
		public ResponseEntity<Booking> update(@PathVariable("bookingId") int bookingId, @RequestBody Booking booking) {
			booking.setBookingId(bookingId);
			Booking modBooking = bookingService.updateBooking(booking);
			return ResponseEntity.ok(modBooking);
		}
		

		@DeleteMapping("deleteBooking/{bookingId}")
		public ResponseEntity<Boolean> delete(@PathVariable("bookingId") int bookingId) {
			boolean success = bookingService.deleteById(bookingId);
			return ResponseEntity.ok(success);
		}
		
		@DeleteMapping("/deleteAll")
		public ResponseEntity<Boolean> deleteAll() {
			boolean success = bookingService.deleteAll();
			return ResponseEntity.ok(success);
		}
	

}
