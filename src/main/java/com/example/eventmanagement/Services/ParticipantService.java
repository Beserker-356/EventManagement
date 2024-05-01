package com.example.eventmanagement.Services;

import com.example.eventmanagement.Exceptions.ParticipantNotFoundException;
import com.example.eventmanagement.Models.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant createParticipant(Participant participant);

    Optional<Participant> updateParticipant(Participant participant);

    void deleteParticipant(Long id);

    Optional<Participant> getParticipantById(Long id);

    List<Participant> getAllParticipants();

}
