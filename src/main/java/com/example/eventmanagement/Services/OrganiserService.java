package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Organiser;

import java.util.List;

public interface OrganiserService {
    Organiser createOrganiser(Organiser organiser);
    String deleteOrganiser(long organiserId);

    Organiser updateOrganiser(Organiser organiser);

    Organiser getOrganiserById(long organiserId);

    List<Organiser> getAllOrganisers();
}
