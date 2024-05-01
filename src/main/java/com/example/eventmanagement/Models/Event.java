package com.example.eventmanagement.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    private long id;
    private String name;
    private String desc;
    private String date;
    private int startTime;
    private int endTime;
    private Venue venue;
}
