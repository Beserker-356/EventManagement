package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Services.OrganiserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organiser")
public class OrganiserController {

    private OrganiserService organiserService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final String port = "At http://localhost:8080/organiser";
    public OrganiserController(OrganiserService organiserService) {
        this.organiserService = organiserService;
    }

    @PostMapping("")
    public Organiser createOrganiser(@RequestBody Organiser organiser) {
        LOGGER.info(port + " -> POST request received to create an Organiser with request body:{}", organiser.toString());
        //organiserService.createOrganiser();
        return organiserService.createOrganiser(organiser);
    }

    @PutMapping("/{id}")
    public Organiser updateOrganiser(@PathVariable("id") long organiserId, @RequestBody Organiser organiser) {
        LOGGER.info(port + "/" + organiserId + " -> PUT request received to update Organiser details with ID: {} with request body: {}", organiserId, organiser.toString());
        return organiserService.updateOrganiser(organiser, organiserId);
    }

    @DeleteMapping("/{organiserId}")
    public String deleteOrganiser(@PathVariable long organiserId) {
        LOGGER.info(port + "/"+ organiserId +" -> DELETE request received to delete Organiser ID: {}", organiserId);
        return organiserService.deleteOrganiser(organiserId);
    }

    @GetMapping("/{organiserId}")
    public Organiser getOrganiser(@PathVariable long organiserId) {
        LOGGER.info(port + "/"+ organiserId +" -> GET request received for Organiser ID: {}", organiserId);
        return organiserService.getOrganiserById(organiserId);
    }

    @GetMapping("")
    public List<Organiser> getAllOrganisers() {
        LOGGER.info(port + " -> GET request received for all organisers");
        return organiserService.getAllOrganisers();
    }






}
