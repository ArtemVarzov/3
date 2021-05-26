package com.example.demo.service.impl;

import com.example.demo.entity.Plane;
import com.example.demo.repository.PlaneRepository;
import com.example.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements GeneralService<Plane> {

    @Autowired
    PlaneRepository planeRepository;

    @Override
    public void save(Plane plane) {
        planeRepository.save(plane);
    }

    @Override
    public List<Plane> findAll() {
        return planeRepository.findAll();
    }

    @Override
    public Plane findById(Long id) {
        return planeRepository.findPlaneById(id);
    }

    @Override
    public void delete(Long id) {
        planeRepository.deleteById(id);
    }

}
