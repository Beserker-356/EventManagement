package com.example.eventmanagement.ExceptionHandlers;

import com.example.eventmanagement.Dtos.ExceptionDto;
import com.example.eventmanagement.Exceptions.EventNotFoundException;
import com.example.eventmanagement.Exceptions.OrganiserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrganiserNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleOrganiserNotFoundException(OrganiserNotFoundException organiserNotFoundException) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Organiser with id " + organiserNotFoundException.getId() + " not found.");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleEventNotFoundException(EventNotFoundException eventNotFoundException) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Event with id " + eventNotFoundException.getId() + " not found");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        return response;
    }
}
