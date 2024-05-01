package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Repositories.VenueRepository;
import org.springframework.stereotype.Service;

@Service

public class AdminServiceImpl implements AdminService{

    private VenueRepository venueRepository;
    public AdminServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public Venue createVenue(Venue venue) {
        Venue ven =  venueRepository.save(venue);
        //System.out.println("Organiser created");
        return ven;

    }
}
