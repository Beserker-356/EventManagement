package com.example.eventmanagement.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Organiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long organiserId;

    private String name;
    private String email;
    private long phone_no;
    private String password;

}
