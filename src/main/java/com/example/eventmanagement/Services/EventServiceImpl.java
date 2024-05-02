package com.example.eventmanagement.Services;

import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Dtos.ScheduleDto;
import com.example.eventmanagement.Exceptions.EventNotFoundException;
import com.example.eventmanagement.Exceptions.OrganiserNotFoundException;
import com.example.eventmanagement.Exceptions.OrganiserPassMismatchException;
import com.example.eventmanagement.Exceptions.ScheduleCoincidingException;
import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Models.Organiser;
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
    private OrganiserService organiserService;

    private boolean validateOrganiser(long ordId, EventDto eventDto) {
        Organiser org = this.organiserService.getOrganiserById(ordId);
        if(org == null)
            throw new OrganiserNotFoundException("Invalid orgID", ordId);

        String password = org.getPassword();

        if(!password.equals(eventDto.getPassword()))
            throw new OrganiserPassMismatchException("Incorrect password for " + org.getName());

        return true;
    }
    private ScheduleRepository scheduleRepository;

    private VenueRepository venueRepository;

    public EventServiceImpl(OrganiserService organiserService, EventRepository eventRepository, ScheduleRepository scheduleRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.organiserService = organiserService;
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
    public Event createEvent(EventDto eventDto, long orgId) {
        if (validateOrganiser(orgId, eventDto))
            return this.eventRepository.save(convertEventDtoToEvent(eventDto));
        return null;
    }

    @Override
    public Event updateEvent(EventDto eventDto, long eventId, long orgId) {
        if (getEventById(eventId) == null)
            throw new EventNotFoundException("Invalid EventId passed", eventId);

        if (validateOrganiser(orgId, eventDto)) {
            Event event = convertEventDtoToEvent(eventDto);
            event.setEventId(orgId);
            return this.eventRepository.save(event);
        }
        return null;
    }

    @Override
    public String deleteEvent(EventDto eventDto, long eventId, long orgId) {
        if(getEventById(eventId) == null)
            throw new EventNotFoundException("Invalid eventID", eventId);

        if (validateOrganiser(orgId, eventDto)) {
            this.eventRepository.deleteById(eventId);
            return "Event with ID " + eventId + " deleted successfully";
        }
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public Schedule createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = convertScheduleDtoToSchedule(scheduleDto);
        List<Schedule> schedules = this.scheduleRepository.findByStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndVenue(schedule.getEndTime(), schedule.getStartTime(), schedule.getVenue());

        if (!schedules.isEmpty())
            throw new ScheduleCoincidingException("Schedule with overlapping time intervals already exists , please change the time interval or venue");

        schedule = this.scheduleRepository.save(schedule);
        return schedule;
    }

    @Override
    public Schedule getScheduleById(long scheduleId) {
        return this.scheduleRepository.findById(scheduleId).orElse(null);
    }
}
