package com.example.eventmanagement.Services;

import com.example.eventmanagement.Exceptions.ParticipantNotFoundException;
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

    @Override
    public Participant updateParticipant(Participant participant) throws ParticipantNotFoundException {
        if (getParticipantById(participant.getId()) == null) {
            throw new ParticipantNotFoundException("Invalid participant id passed");
        }
        participantRepository.save(participant);
        return participant;
    }

    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }


}
