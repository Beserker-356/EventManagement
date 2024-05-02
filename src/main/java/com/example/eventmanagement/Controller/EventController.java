package com.example.eventmanagement.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Dtos.ScheduleDto;
import com.example.eventmanagement.Exceptions.OrganiserPassMismatchException;
import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Models.Schedule;
import com.example.eventmanagement.Services.EventService;
import com.example.eventmanagement.Services.OrganiserService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
    private final String port = "At http://localhost:8080/events";
    private EventService eventService;
    private OrganiserService organiserService;
    public EventController(EventService eventService, OrganiserService organiserService) {
        this.eventService = eventService;
        this.organiserService = organiserService;
    }
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") long eventId) {
        LOGGER.info(port + "/" + eventId + " -> GET request received for Event ID: {}", eventId);
        return this.eventService.getEventById(eventId);
    }
    @GetMapping("")
    public List<Event> getAllEvents() {
        LOGGER.info(port + " -> GET request received for all events");
        return this.eventService.getAllEvents();
    }
    @PostMapping("/{orgId}")
    public Event createEvent(@PathVariable("orgId") long orgId, @RequestBody EventDto eventDto) {
        LOGGER.info(port + "/" + orgId + " -> POST request received to create event for Organiser ID: {} with request body:{}", orgId, eventDto.toString());
        return this.eventService.createEvent(eventDto, orgId);
    }

    @PutMapping("/{orgId}/{eventId}")
    public Event updateEvent(@PathVariable("orgId") long orgId, @RequestBody EventDto eventDto, @PathVariable("eventId") long eventId) {
        LOGGER.info(port + orgId + "/" + eventId + " -> PUT request received to update Event ID: {} for Organiser ID: {} with request body: {}", eventId, orgId, eventDto.toString());
        return this.eventService.updateEvent(eventDto, eventId, orgId);
    }

    @DeleteMapping("/{orgId}/{eventId}")
    public String deleteEvent(@PathVariable("orgId") long orgId, @RequestBody EventDto eventDto, @PathVariable("eventId") long eventId) {
        LOGGER.info(port + "/"+ orgId + "/" + eventId +" -> DELETE request received to delete Event ID: {} by Organiser ID: {} with request body:{}", eventId, orgId, eventDto.toString());
        return this.eventService.deleteEvent(eventDto, eventId, orgId);
    }


    //Schedule CRUD operations
    @PostMapping("/{orgId}/schedule")
    public Schedule createSchedule(@PathVariable("orgId") long orgId, @RequestBody ScheduleDto scheduleDto) {
        LOGGER.info(port + "/" + orgId + " -> POST request received to create Schedule by Organiser ID: {}", orgId);
        Organiser org = this.organiserService.getOrganiserById(orgId);
        String password = org.getPassword();

        if (!password.equals(scheduleDto.getPassword()))
            throw new OrganiserPassMismatchException("Incorrect password for organiser " + org.getName());

        return this.eventService.createSchedule(scheduleDto);
    }

    @GetMapping("/schedule/{scheduleId}")
    public Schedule getScheduleById(@PathVariable long scheduleId) {
        LOGGER.info(port + "/schedule/" + scheduleId + " -> GET request received for Schedule ID: {}", scheduleId);
        return this.eventService.getScheduleById(scheduleId);
    }



}
