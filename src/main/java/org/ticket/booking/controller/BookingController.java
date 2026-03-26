package org.ticket.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ticket.booking.dto.BookingRequest;
import org.ticket.booking.entity.Seat;
import org.ticket.booking.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // ✅ Get Available Seats
    @GetMapping("/shows/{showId}/seats")
    public List<Seat> getSeats(@PathVariable Long showId) {
        return bookingService.getAvailableSeats(showId);
    }

    // ✅ Book Seats
    @PostMapping("/book")
    public String bookSeats(@RequestBody BookingRequest request) {
        return bookingService.bookSeats(request.getShowId(), request.getSeatIds());
    }
}
