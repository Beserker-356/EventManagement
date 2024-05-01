package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository {
    Registration save(Registration registration);
    void deleteById(Long id);
    Optional<Registration> findById(Long id);

}
