package com.cybage.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.FeedbackDao;
import com.cybage.model.Feedback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FeedbackService {

			@Autowired
			private FeedbackDao feedbackDao;

			public Feedback addFeedback(Feedback feedback) {
				return feedbackDao.save(feedback);
			}

			public List<Feedback> getAllFeedbacks() {
				List<Feedback> feedbacks = new ArrayList<Feedback>();
				feedbackDao.findAll().forEach(feedback1 -> feedbacks.add(feedback1));
				return feedbacks;
			}

			public Feedback updateFeedback(Feedback feedback) {
				return feedbackDao.save(feedback);
			}

			public boolean deleteById(int feedbackId) {
				if (feedbackDao.existsById(feedbackId)) {
					feedbackDao.deleteById(feedbackId);
					return true;
				}
				return false;
			}

			public Feedback findById(int id) {
				Optional<Feedback> feedback = feedbackDao.findById(id);
				return feedback.orElse(null);
			}
			
			public boolean deleteAll() {
				feedbackDao.deleteAll();
				return false;
			}

	

}
