package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant save(Participant participant);
    void deleteById(Long id);
}
