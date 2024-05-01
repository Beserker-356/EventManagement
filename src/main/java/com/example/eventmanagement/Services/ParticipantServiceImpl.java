package com.example.eventmanagement.Services;

import com.example.eventmanagement.Exceptions.ParticipantNotFoundException;
import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService{
    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }
    @Override
    public Participant createParticipant(Participant participant) {
        Participant newParticipant = participantRepository.save(participant);
        return newParticipant;
    }

    @Override
    public Optional<Participant> updateParticipant(Participant participant) throws ParticipantNotFoundException {
        Optional<Participant> existingParticipant = getParticipantById(participant.getId());
        participantRepository.save(participant);
        return Optional.of(participant);
    }

    public Optional<Participant> getParticipantById(Long id) {
        Optional<Participant> existingParticipant = participantRepository.findById(id);
        if (existingParticipant.isEmpty()) {
            throw new ParticipantNotFoundException("Participant with the given "+id+" id not found!");
        }
        return existingParticipant;
    }

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }


}
