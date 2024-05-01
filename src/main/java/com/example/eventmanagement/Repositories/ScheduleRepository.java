package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Schedule;
import com.example.eventmanagement.Models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.*;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

    Schedule save(Schedule schedule);

    Optional<Schedule> findById(long id);

    // Query method to find schedules with overlapping time intervals for the given venue
    List<Schedule> findByStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndVenue(
            LocalDateTime newEndTime, LocalDateTime newStartTime, Venue venue);
}
