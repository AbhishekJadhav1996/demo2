package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {

}
