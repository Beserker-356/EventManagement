package com.example.eventmanagement.Exceptions;

import com.example.eventmanagement.Models.Organiser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganiserNotFoundException extends RuntimeException{
    private Long id;

    public OrganiserNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }
}
