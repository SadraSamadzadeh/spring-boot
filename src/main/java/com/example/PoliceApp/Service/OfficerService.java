package com.example.PoliceApp.Service;


import com.example.PoliceApp.Modal.CrimeDetails;
import com.example.PoliceApp.Modal.Officer;
import com.example.PoliceApp.Repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficerService {
    private final OfficerRepository officerRepository;

    @Autowired
    public OfficerService(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }

    public ResponseEntity<Object> newOfficer(Officer officer) {
        officerRepository.save(officer);
        return new ResponseEntity<>(officer, HttpStatus.CREATED);
    }
    public ResponseEntity<Object> updateOfficer(int id, Officer updatedOfficer) {
        Optional<Officer> officerOptional = officerRepository.findById(id);

        if (!officerOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        Officer existingOfficer = officerOptional.get();
        existingOfficer.setUsername(updatedOfficer.getUsername());
        officerRepository.save(existingOfficer);
        return ResponseEntity.ok(existingOfficer);
    }

    public ResponseEntity<Object> deleteOfficer(int id) {
        Optional<Officer> officerOptional = officerRepository.findById(id);
        if (!officerOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        officerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<Object> findOfficerById(int id) {
        Optional<Officer> officerOptional = officerRepository.findById(id);
        if (!officerOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        Officer officer = officerOptional.get();
        return ResponseEntity.ok(officer);
    }
    public List<Officer> getOfficers() {
        return this.officerRepository.findAll();
    }
}
