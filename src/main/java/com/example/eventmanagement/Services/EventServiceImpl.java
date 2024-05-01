package com.example.eventmanagement.Services;

import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Dtos.ScheduleDto;
import com.example.eventmanagement.Exceptions.EventNotFoundException;
import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Models.Schedule;
import com.example.eventmanagement.Models.Venue;
import com.example.eventmanagement.Repositories.EventRepository;
import com.example.eventmanagement.Repositories.ScheduleRepository;
import com.example.eventmanagement.Repositories.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;

    private ScheduleRepository scheduleRepository;

    private VenueRepository venueRepository;

    public EventServiceImpl(EventRepository eventRepository, ScheduleRepository scheduleRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.scheduleRepository = scheduleRepository;
        this.venueRepository = venueRepository;
    }
    private Event convertEventDtoToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());

        return event;
    }

    private Schedule convertScheduleDtoToSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setStartTime(scheduleDto.getStartTime());
        schedule.setEndTime(scheduleDto.getEndTime());
        schedule.setVenue(scheduleDto.getVenue());
        schedule.setOrganiser(scheduleDto.getOrganiser());
        schedule.setEvent(scheduleDto.getEvent());
        schedule.setEntryFees(scheduleDto.getEntryFees());
        Venue venue = this.venueRepository.findById(scheduleDto.getVenue().getVenueId()).orElse(null);
        schedule.setRemainingSeats((int)venue.getCapacity());
        return schedule;
    }

    @Override
    public Event getEventById(long id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event createEvent(EventDto eventDto) {
        Event event = this.eventRepository.save(convertEventDtoToEvent(eventDto));
        return event;
    }

    @Override
    public Event updateEvent(EventDto eventDto, long id) {
        if (getEventById(id) == null)
            throw new EventNotFoundException("Invalid EventId passed", id);

        Event event = convertEventDtoToEvent(eventDto);
        event.setEventId(id);
        return this.eventRepository.save(event);
    }

    @Override
    public String deleteEvent(long eventId) {
        this.eventRepository.deleteById(eventId);
        return "Event with ID " + eventId + " deleted successfully";
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public Schedule createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = this.scheduleRepository.save(convertScheduleDtoToSchedule(scheduleDto));
        return schedule;
    }

    @Override
    public Schedule getScheduleById(long scheduleId) {
        return this.scheduleRepository.findById(scheduleId).orElse(null);
    }
}
