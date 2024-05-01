package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Registration;

import java.util.Optional;

public interface RegistrationService {
    Registration createRegister(Registration registration);

    void deleteRegistration(Long id);

    Optional<Registration> cancelRegistration(Registration registration);

    Optional<Registration> getRegistrationById(Long id);
}
