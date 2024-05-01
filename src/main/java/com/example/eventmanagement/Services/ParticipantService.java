package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Participant;

import java.util.Optional;

public interface ParticipantService {
    Participant createParticipant(Participant participant);

    Optional<Participant> updateParticipant(Participant participant);

    void deleteParticipant(Long id);

    public Optional<Participant> getParticipantById(Long id);

}
