package com.example.eventmanagement.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Registration {
    private long registerId;
    private Schedule schedule;
    private Participant participant;
}
