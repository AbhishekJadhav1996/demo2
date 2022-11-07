package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

	
}