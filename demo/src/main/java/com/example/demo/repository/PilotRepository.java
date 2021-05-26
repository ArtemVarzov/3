package com.example.demo.repository;

import com.example.demo.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "pilot", path = "pilot")
public interface PilotRepository extends JpaRepository<Pilot, Long> {
    Pilot findPilotById(Long id);

    Pilot findPilotByName(String name);

    Pilot findPilotByMail(String mail);
}
