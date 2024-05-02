package com.example.eventmanagement.Services;

import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Dtos.ScheduleDto;
import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Models.Schedule;

import java.util.List;

public interface EventService {
    Event getEventById(long id);
    Event createEvent(EventDto eventDto, long orgId);
    Event updateEvent(EventDto eventDto, long eventId, long orgId);
    String deleteEvent(EventDto eventDto, long eventId, long orgId);
    List<Event> getAllEvents();


    //Schedule CRUD operations
    Schedule createSchedule(ScheduleDto scheduleDto);
    Schedule getScheduleById(long scheduleId);
}
