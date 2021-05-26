package com.example.demo.controller;

import com.example.demo.entity.Pilot;
import com.example.demo.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PilotController {
    @Qualifier("pilotServiceImpl")
    @Autowired
    PilotService pilotService;

    @RequestMapping(value = "/pilot/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pilot> getPilot(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pilot pilot = pilotService.findById(id);

        if (pilot == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pilot, HttpStatus.OK);
    }

    @RequestMapping(value = "/pilot", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pilot> addPilot(@RequestBody Pilot pilot) {
        HttpHeaders headers = new HttpHeaders();
        if (pilot == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.pilotService.save(pilot);
        return new ResponseEntity<>(pilot, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pilot/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pilot> deletePilot(@PathVariable("id") Long id) {
        Pilot pilot = this.pilotService.findById(id);

        if (pilot == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.pilotService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/pilot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pilot>> getAllPilots() {
        List<Pilot> pilots = this.pilotService.findAll();

        if (pilots.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pilots, HttpStatus.OK);
    }
    @RequestMapping(value ="/pilot/findPilotByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pilot> getPilotByName(@RequestParam("name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pilot pilot = this.pilotService.findByName(name);

        if (pilot == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pilot, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pilot> getPilotByMail(@RequestParam("mail") String mail) {
        if (mail == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pilot pilot = this.pilotService.findByMail(mail);

        if (pilot == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pilot, HttpStatus.OK);
    }

}
