package com.example.PoliceApp.Service;


import com.example.PoliceApp.Modal.Crime;
import com.example.PoliceApp.Repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeService {


    private final CrimeRepository crimeRepository;

    @Autowired
    public CrimeService(CrimeRepository crimeRepository)
    {
        this.crimeRepository = crimeRepository;
    }
    public List<Crime> getCrime()
    {
        return this.crimeRepository.findAll();
    }
    public ResponseEntity<Object> newCrime(Crime crime)
    {
        crimeRepository.save(crime);
        return new ResponseEntity<>(crime, HttpStatus.CREATED);
    }
    public ResponseEntity<Object> getCrimeById(Integer id)
    {
        Optional<Crime> crimeOptional = crimeRepository.findById(id);
        if (!crimeOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        Crime crime = crimeOptional.get();
        return ResponseEntity.ok(crime);
    }
    public ResponseEntity<Object> updateCrime(Integer id, Crime updatedCrime)
    {
        Optional<Crime> crimeOptional = crimeRepository.findById(id);
        if(!crimeOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        Crime existingCrime = crimeOptional.get();
        existingCrime.setName(updatedCrime.getName());
        existingCrime.setSeverity(updatedCrime.getSeverity());
        crimeRepository.save(existingCrime);
        return ResponseEntity.ok(existingCrime);
    }
    public ResponseEntity<Object> deleteCrime(Integer id) {
        Optional<Crime> crimeOptional = crimeRepository.findById(id);
        if (!crimeOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        crimeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
