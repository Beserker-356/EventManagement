package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

    Schedule save(Schedule schedule);

    Optional<Schedule> findById(long id);
}
