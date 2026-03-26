package org.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticket.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
