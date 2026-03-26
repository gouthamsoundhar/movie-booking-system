package org.ticket.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    private Long showId;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Version
    private Integer version;
}
