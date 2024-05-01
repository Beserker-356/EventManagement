package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant save(Participant participant);


}
