package com.example.eventmanagement.Services;

import com.example.eventmanagement.Exceptions.ParticipantNotFoundException;
import com.example.eventmanagement.Helper_enum.RegistrationStatus;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration createRegister(Registration registration) {

        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public Optional<Registration> cancelRegistration(Registration registration) {
        Optional<Registration> existingRegistration = getRegistrationById(registration.getRegisterId());
        registration.setStatus(RegistrationStatus.valueOf("CANCELLED"));
        return Optional.of(registration);
    }

    public Optional<Registration> getRegistrationById(Long id) {
        Optional<Registration> existingRegistration = registrationRepository.findById(id);
        if (existingRegistration.isEmpty()) {
            throw new ParticipantNotFoundException("Registration with the given "+id+" id not found!");
        }
        return existingRegistration;
    }
}
