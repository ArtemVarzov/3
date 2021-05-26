package com.example.demo.repository;

import com.example.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "manager", path = "manager")

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findManagerById(Long id);
}
