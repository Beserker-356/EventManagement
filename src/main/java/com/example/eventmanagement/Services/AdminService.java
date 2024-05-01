package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Venue;

import java.util.List;

public interface AdminService {


    List<Venue> getAllVenues();

    Venue getVenueById(long venueId);


}
