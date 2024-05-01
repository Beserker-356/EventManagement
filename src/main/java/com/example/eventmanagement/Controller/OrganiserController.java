package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Services.OrganiserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organiser")
public class OrganiserController {

    private OrganiserService organiserService;

    public OrganiserController(OrganiserService organiserService) {
        this.organiserService = organiserService;
    }

    @PostMapping("")
    public void createOrganiser() {
        //organiserService.createOrganiser();
    }

    @PutMapping("")
    public void updateOrganiser() {
        //organiserService.updateOrganiser();
    }




}
