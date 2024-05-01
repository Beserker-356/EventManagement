package com.example.eventmanagement.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventNotFoundException extends RuntimeException {
    private long id;
    public EventNotFoundException(String message, long id) {
        super(message);
        this.id = id;
    }
}
