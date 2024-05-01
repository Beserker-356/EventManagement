package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantSecviceImpl implements ParticipantService{
    private ParticipantRepository participantRepository;

    public ParticipantSecviceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }
    @Override
    public Participant createParticipant(Participant participant) {
        Participant newParticipant = participantRepository.save(participant);
        return newParticipant;
    }
}
