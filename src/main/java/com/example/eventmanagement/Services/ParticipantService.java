package com.example.eventmanagement.Services;

import com.example.eventmanagement.Exceptions.ParticipantNotFoundException;
import com.example.eventmanagement.Models.Participant;

import java.util.Optional;

public interface ParticipantService {
    Participant createParticipant(Participant participant);

    Participant updateParticipant(Participant participant) throws ParticipantNotFoundException;

    void deleteParticipant(Long id);

    public Participant getParticipantById(Long id);

}
