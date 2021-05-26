package com.example.demo.service;

import com.example.demo.entity.Pilot;

public interface PilotService extends GeneralService <Pilot>{
    Pilot findByName(String name);

    Pilot findByMail(String mail);
}
