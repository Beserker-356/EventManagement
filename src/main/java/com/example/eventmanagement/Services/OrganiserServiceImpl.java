package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Repositories.OrganiserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganiserServiceImpl implements OrganiserService{

    private OrganiserRepository organiserRepository;
    public OrganiserServiceImpl(OrganiserRepository organiserRepository) {
        this.organiserRepository = organiserRepository;
    }

    @Override
    public Organiser createOrganiser(Organiser organiser) {
        Organiser org =  organiserRepository.save(organiser);
        //System.out.println("Organiser created");
        return org;
    }
}
