package com.example.eventmanagement.Models;

import com.example.eventmanagement.Helper_enum.RegistrationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long registerId;

    @ManyToOne
    private Schedule schedule;

    @ManyToOne
    private Participant participant;

    private RegistrationStatus status;
}
