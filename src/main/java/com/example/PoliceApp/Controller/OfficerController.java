package com.example.PoliceApp.Controller;


import com.example.PoliceApp.Modal.Officer;
import com.example.PoliceApp.Service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/officer")
public class OfficerController {
    private final OfficerService officerService;


    @Autowired

    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createOfficer (@RequestBody Officer officer) {
        return this.officerService.newOfficer(officer);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateOfficerById (@PathVariable int id, @RequestBody Officer officer) {
        return this.officerService.updateOfficer(id, officer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOfficerById (@PathVariable int id) {
        return this.officerService.deleteOfficer(id);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getOfficerById (@PathVariable int id) {
        return this.officerService.findOfficerById(id);
    }

    @GetMapping
    public List<Officer> getOfficers () {
        return this.officerService.getOfficers();
    }
}
