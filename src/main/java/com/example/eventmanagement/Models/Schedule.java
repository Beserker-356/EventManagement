package com.example.eventmanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Venue venue;

    @ManyToOne
    private Organiser organiser;


    @ManyToOne
    private Event event;

    private double entryFees;

    private int remainingSeats;
}
