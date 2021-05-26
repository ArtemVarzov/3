package com.example.demo.controller;

import com.example.demo.entity.Manager;
import com.example.demo.entity.Plane;
import com.example.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Qualifier("managerServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> getManager(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Manager manager = (Manager) generalService.findById(id);

        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @RequestMapping(value = "/manager", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
        HttpHeaders headers = new HttpHeaders();
        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.generalService.save(manager);
        return new ResponseEntity<>(manager, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> deleteManager(@PathVariable("id") Long id) {
        Manager manager = (Manager) generalService.findById(id);

        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = this.generalService.findAll();

        if (managers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }
}
