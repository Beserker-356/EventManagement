package com.example.eventmanagement.Exceptions;

public class ScheduleCoincidingException extends RuntimeException {
    public ScheduleCoincidingException(String message) {
        super(message);
    }
}
