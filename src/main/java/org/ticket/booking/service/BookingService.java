package org.ticket.booking.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.ticket.booking.entity.Booking;
import org.ticket.booking.entity.Seat;
import org.ticket.booking.entity.SeatStatus;
import org.ticket.booking.repository.BookingRepository;
import org.ticket.booking.repository.SeatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;

    // ✅ Get Available Seats
    public List<Seat> getAvailableSeats(Long showId) {
        return seatRepository.findByShowId(showId)
                .stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .toList();
    }

    @Transactional
    public String bookSeats(Long showId, List<Long> seatIds) {

        List<Seat> seats = seatRepository.findAllById(seatIds);

        for (Seat seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
               // throw new RuntimeException("Seat already booked: " + seat.getSeatNumber());
                return "seat already booked " + seat.getSeatNumber();
            }
        }

        try {
            for (Seat seat : seats) {
                seat.setStatus(SeatStatus.BOOKED);
            }

            seatRepository.saveAll(seats);

        } catch (ObjectOptimisticLockingFailureException ex) {
            throw new RuntimeException("Seat already booked by another user. Please retry!");
        }

        for (Seat seat : seats) {
            Booking booking = new Booking();
            booking.setShowId(showId);
            booking.setSeatId(seat.getId());
            bookingRepository.save(booking);
        }

        return "Booking successful!";
    }
}
