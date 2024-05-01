package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant createParticipant(Participant participant);

    Optional<Participant> updateParticipant(Participant participant);

    List<Participant> getAllParticipants();

    void deleteParticipant(Long id);

    public Optional<Participant> getParticipantById(Long id);

}
