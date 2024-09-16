package com.example.PoliceApp.Controller;

import com.example.PoliceApp.Modal.CrimeDetails;
import com.example.PoliceApp.Service.CrimeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crimedetails")
public class CrimeDetailsController {

    private final CrimeDetailsService crimeDetailsService;

    @Autowired
    public CrimeDetailsController(CrimeDetailsService crimeDetailsService) {
        this.crimeDetailsService = crimeDetailsService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createCrimeDetail(@RequestBody CrimeDetails crimeDetails) {
        return this.crimeDetailsService.newCrimeDetail(crimeDetails);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateCrimeDetailById(@PathVariable Integer id, @RequestBody CrimeDetails updatedCrimeDetail) {
        return this.crimeDetailsService.updateCrimeDetail(id, updatedCrimeDetail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCrimeDetailById(@PathVariable Integer id) {
        return this.crimeDetailsService.deleteCrimeDetail(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCrimeDetailsById(@PathVariable Integer id) {
        return this.crimeDetailsService.getCrimeDetailById(id);
    }
    @GetMapping("/get")
    public List<CrimeDetails> getCrimeDetails()
    {
        return this.crimeDetailsService.getCrimeDetails();
    }

}