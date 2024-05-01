package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Repositories.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{

    private VenueRepository venueRepository;

    public AdminServiceImpl (VenueRepository venueRepository){ this.venueRepository = venueRepository;}

    @Override
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    @Override
    public Venue getVenueById(long venueId){
        return venueRepository.findById(venueId).orElse(null);
    }

}
