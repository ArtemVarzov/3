package com.example.demo.repository;

import com.example.demo.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "plane", path = "plane")
public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Plane findPlaneById(Long id);
}
