package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.dao.BookingDao;
import com.cybage.model.Booking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BookingService {
		@Autowired
		private BookingDao bookingDao;

		public Booking addBooking(Booking booking) {
			return bookingDao.save(booking);
		}

		public List<Booking> getAllBookings() {
			List<Booking> bookings = new ArrayList<Booking>();
			bookingDao.findAll().forEach(booking1 -> bookings.add(booking1));
			return bookings;
		}

		public Booking updateBooking(Booking booking) {
			return bookingDao.save(booking);
		}

		public boolean deleteById(int bookingId) {
			if (bookingDao.existsById(bookingId)) {
				bookingDao.deleteById(bookingId);
				return true;
			}
			return false;
		}

		public Booking findById(int id) {
			Optional<Booking> booking = bookingDao.findById(id);
			return booking.orElse(null);
		}
		
		public boolean deleteAll() {
			bookingDao.deleteAll();
			return false;
		}
}
