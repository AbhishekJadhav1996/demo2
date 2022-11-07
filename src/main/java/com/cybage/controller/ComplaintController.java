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

import com.cybage.model.Complaint;
import com.cybage.service.ComplaintService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/complaint")
public class ComplaintController {


		@Autowired
		ComplaintService complaintService;
		
		@GetMapping("/{complaintId}")
		public ResponseEntity<?> findById(@PathVariable("complaintId") int complaintId) {
			Complaint complaint = complaintService.findById(complaintId);
			Map<String, Object> map = new HashMap<>();
			map.put("status", "success");
			map.put("data", complaint);
			return ResponseEntity.ok(map);
		}
		
		@PostMapping("/add")
		public ResponseEntity<Complaint> save(@RequestBody Complaint complaint) {
			complaint = complaintService.addComplaint(complaint);
			return ResponseEntity.ok(complaint);
			
		}
		
		@GetMapping("/all")
		public ResponseEntity<List<Complaint>> findAll() {
			List<Complaint> list = complaintService.getAllComplaints();
			return ResponseEntity.ok(list);
			
		}	

		
		@PutMapping("update/{complaintId}")
		public ResponseEntity<Complaint> update(@PathVariable("complaintId") int complaintId, @RequestBody Complaint complaint) {
			complaint.setComplaintId(complaintId);
			Complaint modComplaint = complaintService.updateComplaint(complaint);
			return ResponseEntity.ok(modComplaint);
		}
		

		@DeleteMapping("deleteComplaint/{complaintId}")
		public ResponseEntity<Boolean> delete(@PathVariable("complaintId") int complaintId) {
			boolean success = complaintService.deleteById(complaintId);
			return ResponseEntity.ok(success);
		}
		
		@DeleteMapping("/deleteAll")
		public ResponseEntity<Boolean> deleteAll() {
			boolean success = complaintService.deleteAll();
			return ResponseEntity.ok(success);
		}
	

}
