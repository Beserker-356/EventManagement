package com.example.eventmanagement.Controller;


import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final String port = "At http://localhost:8080/admin";
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("")
    public Venue createVenue(@RequestBody Venue venue) {
        LOGGER.info(port + " -> POST request received to create a Venue");
        //AdminService.createVenue();
        return adminService.createVenue(venue);
    }

    @GetMapping("")
    public List<Venue> getAllVenues() {
        LOGGER.info(port + " -> GET request received for all Venues");
        return adminService.getAllVenues();
    }


    @GetMapping("/{venueId}")
    public Venue getVenueById(@PathVariable long venueId) {
        LOGGER.info(port + " -> GET request received for Venue ID: {}", venueId);
        return adminService.getVenueById(venueId);
    }

    @PutMapping("{venueId}")
    public Venue updateVenue(@PathVariable long venueId,@RequestBody Venue venue) {
        return adminService.updateVenue(venue, venueId);
    }

}
