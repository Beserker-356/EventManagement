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

    @PutMapping("/{id}")
    public Organiser updateOrganiser(@PathVariable("id") long organiserId, @RequestBody Organiser organiser) {
        return organiserService.updateOrganiser(organiser, organiserId);
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






}
