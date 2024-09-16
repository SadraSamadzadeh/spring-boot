package com.example.PoliceApp.Controller;


import com.example.PoliceApp.Modal.Crime;
import com.example.PoliceApp.Service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crime")
public class CrimeController {

    private final CrimeService crimeService;


    @Autowired

    public CrimeController(CrimeService crimeService) {
        this.crimeService = crimeService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createCrime (@RequestBody Crime crime)
    {
        return this.crimeService.newCrime(crime);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateCrimeById (@PathVariable Integer id, @RequestBody Crime updatedCrime)
    {
        return this.crimeService.updateCrime(id, updatedCrime);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCrimeById(@PathVariable Integer id)
    {
        return this.crimeService.deleteCrime(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCrimeById(@PathVariable Integer id)
    {
        return this.crimeService.getCrimeById(id);
    }
    @GetMapping("/get")
    public List<Crime> getCrime()
    {
        return this.crimeService.getCrime();
    }
}
