package com.example.eventmanagement.Controller;


import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("")
    public Venue createVenue(@RequestBody Venue venue) {
        //AdminService.createVenue();
        return adminService.createVenue(venue);
    }

    @GetMapping("")
    public List<Venue> getAllVenues() {
        return adminService.getAllVenues();
    }


    @GetMapping("/{venueId}")
    public Venue getVenueById(@PathVariable long venueId) {
        return adminService.getVenueById(venueId);
    }

    @PutMapping("{venueId}")
    public Venue updateVenue(@PathVariable long venueId,@RequestBody Venue venue) {
        return adminService.updateVenue(venue, venueId);
    }

}
