package org.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticket.booking.entity.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowId(Long showId);
}
