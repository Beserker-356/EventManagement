package com.example.eventmanagement.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venue {
    private long venueId;
    private String name;
    private String address;
    private long capacity;
}
