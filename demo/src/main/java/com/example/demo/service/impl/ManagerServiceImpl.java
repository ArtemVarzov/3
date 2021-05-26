package com.example.demo.service.impl;

import com.example.demo.entity.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.PilotRepository;
import com.example.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements GeneralService<Manager> {
    @Autowired
    ManagerRepository managerRepository;


    @Override
    public void save(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager findById(Long id) {
        return managerRepository.findManagerById(id);
    }

    @Override
    public void delete(Long id) {
        managerRepository.deleteById(id);
    }
}
