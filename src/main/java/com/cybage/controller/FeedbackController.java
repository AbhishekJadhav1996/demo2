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

import com.cybage.model.Feedback;
import com.cybage.service.FeedbackService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/feedback")
public class FeedbackController {

		@Autowired
		FeedbackService feedbackService;
		
		@GetMapping("/{feedbackId}")
		public ResponseEntity<?> findById(@PathVariable("feedbackId") int feedbackId) {
			Feedback feedback = feedbackService.findById(feedbackId);
			Map<String, Object> map = new HashMap<>();
			map.put("status", "success");
			map.put("data", feedback);
			return ResponseEntity.ok(map);
		}
		
		@PostMapping("/add")
		public ResponseEntity<Feedback> save(@RequestBody Feedback feedback) {
			feedback = feedbackService.addFeedback(feedback);
			return ResponseEntity.ok(feedback);
			
		}
		
		@GetMapping("/all")
		public ResponseEntity<List<Feedback>> findAll() {
			List<Feedback> list = feedbackService.getAllFeedbacks();
			return ResponseEntity.ok(list);
			
		}	

		
		@PutMapping("update/{feedbackId}")
		public ResponseEntity<Feedback> update(@PathVariable("feedbackId") int feedbackId, @RequestBody Feedback feedback) {
			feedback.setFeedbackId(feedbackId);
			Feedback modFeedback = feedbackService.updateFeedback(feedback);
			return ResponseEntity.ok(modFeedback);
		}
		

		@DeleteMapping("deleteFeedback/{feedbackId}")
		public ResponseEntity<Boolean> delete(@PathVariable("feedbackId") int feedbackId) {
			boolean success = feedbackService.deleteById(feedbackId);
			return ResponseEntity.ok(success);
		}
		
		@DeleteMapping("/deleteAll")
		public ResponseEntity<Boolean> deleteAll() {
			boolean success = feedbackService.deleteAll();
			return ResponseEntity.ok(success);
		}
	
	
}
