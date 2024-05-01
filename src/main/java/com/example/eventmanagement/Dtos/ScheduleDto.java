package com.example.eventmanagement.Dtos;

import com.example.eventmanagement.Models.Event;
import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Models.Venue;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleDto {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Venue venue;

    private Organiser organiser;


    private Event event;

    private double entryFees;

    private String password;
}
