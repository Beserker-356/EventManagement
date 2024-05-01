package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Organiser;
import com.example.eventmanagement.Repositories.OrganiserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public String deleteOrganiser(long organiserId) {
        organiserRepository.deleteById(organiserId);
        return "Organiser with ID:"+ organiserId +" is deleted successfully.";
    }

    @Override
    public Organiser updateOrganiser(Organiser organiser) {
        Organiser org = organiserRepository.save(organiser);
        return org;
    }

    @Override
    public Organiser getOrganiserById(long organiserId) {
        return organiserRepository.findById(organiserId).orElse(null);
    }

    @Override
    public List<Organiser> getAllOrganisers() {
        return organiserRepository.findAll();
    }

}
