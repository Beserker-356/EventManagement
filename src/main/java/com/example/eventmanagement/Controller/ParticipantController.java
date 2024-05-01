package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Services.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private ParticipantService participantService;
    ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("")
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantService.createParticipant(participant);
    }

    @PutMapping("")
    public Optional<Participant> updateParticipant(@RequestBody Participant participant) {
        return participantService.updateParticipant(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }

    @GetMapping ("/{id}")
    public Optional<Participant> findParticipantById(@PathVariable Long id) {
        return participantService.getParticipantById(id);
    }

    @GetMapping ("")
    public List<Participant> findParticipants() {
        return participantService.getAllParticipants();
    }

}
