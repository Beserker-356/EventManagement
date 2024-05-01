package com.example.eventmanagement.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Schedule {
    private long scheduleId;
    private Date startTime;
    private Date endTime;
    private Venue venue;
    private Organiser organiser;
    private Event event;
    private double entryFees;
}
