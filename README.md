# movie-booking-system
movie ticket booking

# Movie Ticket Booking System

## Features
- Get available seats
- Book seats
- Seat locking mechanism
- Prevent double booking (Optimistic Locking)

## Tech Stack
- Java
- Spring Boot
- H2 Database

## APIs
- GET /api/shows/{showId}/seats
- POST /api/book

## Concurrency Handling
Used optimistic locking with version field to prevent race conditions.

## Future Enhancements
- Redis caching
- Distributed locking
- Payment integration
