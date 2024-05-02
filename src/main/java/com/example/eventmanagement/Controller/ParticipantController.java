package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Services.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private ParticipantService participantService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final String port = "At http://localhost:8080/participant";
    ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("")
    public Participant createParticipant(@RequestBody Participant participant) {
        LOGGER.info(port + " -> POST request received to create a Participant with request body:{}", participant.toString());
        return participantService.createParticipant(participant);
    }

    @PutMapping("")
    public Optional<Participant> updateParticipant(@RequestBody Participant participant) {
        LOGGER.info(port + " -> PUT request received to create a Participant with request body:{}", participant.toString());
        return participantService.updateParticipant(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        LOGGER.info(port + "/" + id + " -> DELETE request received to delete Participant with ID:{}", id);
        participantService.deleteParticipant(id);
    }

    @GetMapping ("/{id}")
    public Optional<Participant> findParticipantById(@PathVariable Long id) {
        LOGGER.info(port + "/" + id + " -> GET request received for Participant with ID:{}", id);
        return participantService.getParticipantById(id);
    }

    @GetMapping ("")
    public List<Participant> findParticipants() {
        LOGGER.info(port + " -> GET request received for all Participants");
        return participantService.getAllParticipants();
    }

}
