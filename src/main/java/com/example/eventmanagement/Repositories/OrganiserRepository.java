package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Organiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser, Long> {
    Organiser save(Organiser organiser);

    void deleteById(Long organiserId);

    Optional<Organiser> findById(Long organiserId);

    List<Organiser> findAll();



}
