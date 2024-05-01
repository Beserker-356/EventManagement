package com.example.eventmanagement.Services;


import com.example.eventmanagement.Models.Venue;

import com.example.eventmanagement.Models.Venue;

import java.util.List;


import com.example.eventmanagement.Models.Venue;

public interface AdminService {

    Venue createVenue(Venue venue);


    List<Venue> getAllVenues();

    Venue getVenueById(long venueId);

}
