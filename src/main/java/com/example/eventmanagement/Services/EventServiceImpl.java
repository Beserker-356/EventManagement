package com.example.eventmanagement.Services;

import com.example.eventmanagement.Dtos.EventDto;
import com.example.eventmanagement.Exceptions.EventNotFoundException;
import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    private Event convertEventDtoToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setDescription(eventDto.getDescription());

        return event;
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
}
