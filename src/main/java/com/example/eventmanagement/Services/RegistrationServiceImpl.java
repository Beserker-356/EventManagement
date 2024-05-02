package com.example.eventmanagement.Services;

import com.example.eventmanagement.Exceptions.ParticipantNotFoundException;
import com.example.eventmanagement.Helper_enum.RegistrationStatus;
import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Models.Schedule;
import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Repositories.RegistrationRepository;
import com.example.eventmanagement.Repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    private RegistrationRepository registrationRepository;
    private ScheduleRepository scheduleRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, ScheduleRepository scheduleRepository) {
        this.registrationRepository = registrationRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Registration createRegister(Registration registration) {
        Schedule schedule = registration.getSchedule();
        int seats = schedule.getRemainingSeats();
        if (seats > 0) {
            schedule.setRemainingSeats(seats-1);
            registration.setStatus(RegistrationStatus.ACCEPTED);
        }
        else {
            registration.setStatus(RegistrationStatus.REJECTED);
        }
        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        Optional<Registration> registration = getRegistrationById(id);
        Schedule schedule = registration.get().getSchedule();
        int seats = schedule.getRemainingSeats();
        schedule.setRemainingSeats(seats+1);
        registrationRepository.deleteById(id);
    }


    @Override
    public Optional<Registration> cancelRegistration(Long id) {
        Optional<Registration> registration1 = getRegistrationById(id);
        Schedule schedule = registration1.get().getSchedule();
        int seats = schedule.getRemainingSeats();
        schedule.setRemainingSeats(seats+1);
        registration1.get().setStatus(RegistrationStatus.CANCELLED);
        return registration1;
    }

    public Optional<Registration> getRegistrationById(Long id) {
        Optional<Registration> existingRegistration = registrationRepository.findById(id);
        if (existingRegistration.isEmpty()) {
            throw new ParticipantNotFoundException("Registration with the given "+id+" id not found!");
        }
        return existingRegistration;
    }


    @Override
    public Optional<Registration> updateRegistration(Registration registration) {
        Optional<Registration> existingRegistration = getRegistrationById(registration.getRegisterId());
        return Optional.ofNullable(registrationRepository.save(registration));
    }

    @Override
    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }
}
