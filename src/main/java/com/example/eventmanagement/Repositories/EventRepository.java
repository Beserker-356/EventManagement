package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event save(Event event);
    void deleteById(long eventId);
    Optional<Event> findById(long eventId);
    List<Event> findAll();
}
