package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Registration;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
    Registration createRegister(Registration registration);

    void deleteRegistration(Long id);

    Optional<Registration> cancelRegistration(Long id);

    Optional<Registration> getRegistrationById(Long id);

    Optional<Registration> updateRegistration(Registration registration);

    List<Registration> getAllRegistration();
}
