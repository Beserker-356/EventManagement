package com.example.eventmanagement.Controller;


import com.example.eventmanagement.Models.Registration;
import com.example.eventmanagement.Services.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private RegistrationService registrationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final String port = "At http://localhost:8080/register";
    RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("")
    public Registration createRegistration(@RequestBody Registration registration) {
        LOGGER.info(port + " -> POST request received to register");
        return registrationService.createRegister(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable Long id) {
        LOGGER.info(port + "/" + id + " -> DELETE request received to delete Registration with ID:{}", id);
        registrationService.deleteRegistration(id);
    }

    @PutMapping("")
    public Optional<Registration> cancelRegistration(@RequestBody Registration registration) {
        LOGGER.info(port + " -> PUT request received to update Registration");
        return registrationService.cancelRegistration(registration);
    }
    public Optional<Registration> updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }

    @GetMapping("")
    public List<Registration> getAllRegistration() {
        return registrationService.getAllRegistration();
    }

    @GetMapping("/{id}")
    public Optional<Registration> getRegistrationById(@PathVariable Long id) {
        return registrationService.getRegistrationById(id);
    }

    @PutMapping("")
    public Optional<Registration> cancelRegistration(@RequestBody Registration registration) {
        return registrationService.cancelRegistration(registration);
    }
}
