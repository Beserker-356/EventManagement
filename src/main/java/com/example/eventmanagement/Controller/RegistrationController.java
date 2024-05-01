package com.example.eventmanagement.Controller;


import com.example.eventmanagement.Models.Participant;
import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Services.ParticipantService;
import com.example.eventmanagement.Services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private RegistrationService registrationService;
    RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("")
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationService.createRegister(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
    }

    @PutMapping("")
    public Optional<Registration> cancelRegistration(@RequestBody Registration registration) {
        return registrationService.cancelRegistration(registration);
    }
}
