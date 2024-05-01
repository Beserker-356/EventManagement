package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Venue;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository {
    Venue save(Venue venue);
}
