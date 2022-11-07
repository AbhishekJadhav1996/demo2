package com.cybage.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.ComplaintDao;
import com.cybage.model.Complaint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ComplaintService {
	

		@Autowired
		private ComplaintDao complaintDao;

		public Complaint addComplaint(Complaint complaint) {
			return complaintDao.save(complaint);
		}

		public List<Complaint> getAllComplaints() {
			List<Complaint> complaints = new ArrayList<Complaint>();
			complaintDao.findAll().forEach(complaint1 -> complaints.add(complaint1));
			return complaints;
		}

		public Complaint updateComplaint(Complaint complaint) {
			return complaintDao.save(complaint);
		}

		public boolean deleteById(int complaintId) {
			if (complaintDao.existsById(complaintId)) {
				complaintDao.deleteById(complaintId);
				return true;
			}
			return false;
		}

		public Complaint findById(int id) {
			Optional<Complaint> complaint = complaintDao.findById(id);
			return complaint.orElse(null);
		}
		
		public boolean deleteAll() {
			complaintDao.deleteAll();
			return false;
		}

}
