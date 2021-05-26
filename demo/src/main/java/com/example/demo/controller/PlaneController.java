package com.example.demo.controller;

import com.example.demo.entity.Pilot;
import com.example.demo.entity.Plane;
import com.example.demo.service.GeneralService;
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
public class PlaneController {
    @Qualifier("planeServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/plane/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> getPlane(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Plane plane = (Plane) generalService.findById(id);

        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(plane, HttpStatus.OK);
    }

    @RequestMapping(value = "/plane", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> addPlane(@RequestBody Plane plane) {
        HttpHeaders headers = new HttpHeaders();
        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.generalService.save(plane);
        return new ResponseEntity<>(plane, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/plane/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> deletePlane(@PathVariable("id") Long id) {
        Plane plane = (Plane) generalService.findById(id);

        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/plane", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plane>> getAllPlanes() {
        List<Plane> planes = this.generalService.findAll();

        if (planes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(planes, HttpStatus.OK);
    }
}
