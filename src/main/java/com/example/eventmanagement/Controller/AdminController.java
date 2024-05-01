package com.example.eventmanagement.Controller;


import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Services.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/admin")

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


}
