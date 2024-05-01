package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Services.OrganiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organiser")
public class OrganiserController {

    private OrganiserService organiserService;

    public OrganiserController(OrganiserService organiserService) {
        this.organiserService = organiserService;
    }

    @PostMapping("")
    public Organiser createOrganiser(@RequestBody Organiser organiser) {
        //organiserService.createOrganiser();
        return organiserService.createOrganiser(organiser);
    }

    @PutMapping("")
    public Organiser updateOrganiser(@RequestBody Organiser organiser) {
        return organiserService.updateOrganiser(organiser);
    }

    @DeleteMapping("/{organiserId}")
    public String deleteOrganiser(@PathVariable long organiserId) {
        return organiserService.deleteOrganiser(organiserId);
    }

    @GetMapping("/{organiserId}")
    public Organiser getOrganiser(@PathVariable long organiserId) {
        return organiserService.getOrganiserById(organiserId);
    }

    @GetMapping("")
    public List<Organiser> getAllOrganisers() {
        return organiserService.getAllOrganisers();
    }


    // Event CRUD operations
    @PostMapping("/event")
    public void createEvent() {
        //organiserService.createEvent();
    }

    @PutMapping("/event")
    public void updateEvent() {
        //organiserService.updateEvent();
    }

    @DeleteMapping("/event")
    public void deleteEvent() {
        //organiserService.deleteEvent();
    }

    @GetMapping("/event")
    public void getEvent() {
        //organiserService.getEvent();
    }




}
