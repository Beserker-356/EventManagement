package com.example.eventmanagement.Exceptions;

import com.example.eventmanagement.Models.Participant;

public class ParticipantNotFoundException extends RuntimeException{
    public ParticipantNotFoundException(String message) {
        super(message);
    }

}
