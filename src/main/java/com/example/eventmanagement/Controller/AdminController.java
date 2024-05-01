package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Services.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    public AdminController(AdminService adminService) {this.adminService = adminService;}

    @GetMapping("")
    public List<Venue> getAllVenues() {
        return adminService.getAllVenues();
    }


    @GetMapping("/{venueId}")
    public Venue getVenueById(@PathVariable long venueId) {
        return adminService.getVenueById(venueId);
    }



}
