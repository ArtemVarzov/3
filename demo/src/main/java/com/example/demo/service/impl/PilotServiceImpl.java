package com.example.demo.service.impl;

import com.example.demo.entity.Pilot;
import com.example.demo.repository.PilotRepository;
import com.example.demo.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    PilotRepository pilotRepository;

    @Override
    public void save(Pilot pilot) {
        pilotRepository.save(pilot);
    }

    @Override
    public List<Pilot> findAll() {
        return pilotRepository.findAll();
    }

    @Override
    public Pilot findById(Long id) {
        return pilotRepository.findPilotById(id);
    }

    @Override
    public void delete(Long id) {
        pilotRepository.deleteById(id);
    }

    @Override
    public Pilot findByName(String name) {
        return pilotRepository.findPilotByName(name);
    }

    @Override
    public Pilot findByMail(String mail) {
        return pilotRepository.findPilotByMail(mail);
    }
}
