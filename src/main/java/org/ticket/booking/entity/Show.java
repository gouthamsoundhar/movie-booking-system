package org.ticket.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue
    private Long id;

    private Long movieId;
    private String showTime;
}
