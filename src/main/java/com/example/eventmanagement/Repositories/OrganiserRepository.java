package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Organiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser, Long>{

    Organiser save(Organiser organiser);


}
