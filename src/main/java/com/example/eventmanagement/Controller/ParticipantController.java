package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Services.ParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Participant deleteParticipant(@RequestBody Participant participant) {
        return null;
    }

    @PostMapping ("/register")
    public Registration register(@RequestBody Registration registration) {
        return null;
    }
}
