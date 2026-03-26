package org.ticket.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    private Long showId;
    private Long seatId;
}
