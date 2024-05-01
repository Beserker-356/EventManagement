package com.example.eventmanagement.Services;

import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Models.Event;

import java.util.List;

public interface EventService {
    Event getEventById(long id);
    Event createEvent(EventDto eventDto);
    Event updateEvent(EventDto eventDto, long id);
    String deleteEvent(long eventId);
    List<Event> getAllEvents();
}
