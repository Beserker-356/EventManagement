package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration save(Registration registration);
    void deleteById(Long id);
    List<Registration> findAll();
    Optional<Registration> findById(Long id);
}
