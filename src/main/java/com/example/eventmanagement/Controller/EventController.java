package com.example.eventmanagement.Controller;

import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Services.EventService;
import com.example.eventmanagement.Services.OrganiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;
    private OrganiserService organiserService;

    public EventController(EventService eventService, OrganiserService organiserService) {
        this.eventService = eventService;
        this.organiserService = organiserService;
    }
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") long eventId) {
        return this.eventService.getEventById(eventId);
    }
    @GetMapping()
    public List<Event> getAllEvents() {
        return this.eventService.getAllEvents();
    }
    @PostMapping("/{orgId}")
    public Event createEvent(@PathVariable("orgId") long orgId, @RequestBody EventDto eventDto) {
        Organiser org = this.organiserService.getOrganiserById(orgId);
        String password = org.getPassword();

        if (!password.equals(eventDto.getPassword()))
            return null;

        return this.eventService.createEvent(eventDto);
    }

    @PutMapping("/{orgId}/{eventId}")
    public Event updateEvent(@PathVariable("orgId") long orgId, @RequestBody EventDto eventDto, @PathVariable("eventId") long eventId) {
        Organiser org = this.organiserService.getOrganiserById(orgId);
        String password = org.getPassword();

        if (!password.equals(eventDto.getPassword()))
            return null;
        return this.eventService.updateEvent(eventDto, eventId);
    }

    @DeleteMapping("/{orgId}/{eventId}")
    public String deleteEvent(@PathVariable("orgId") long orgId, @RequestBody EventDto eventDto, @PathVariable("eventId") long eventId) {
        Organiser org = this.organiserService.getOrganiserById(orgId);
        String password = org.getPassword();

        if (!password.equals(eventDto.getPassword()))
            return null;

        return this.eventService.deleteEvent(eventId);
    }

}
