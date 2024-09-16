package com.example.PoliceApp.Service;


import com.example.PoliceApp.Modal.CrimeDetails;
import com.example.PoliceApp.Repository.CrimeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeDetailsService {

    private final CrimeDetailsRepository crimeDetailsRepository;

    @Autowired
    public CrimeDetailsService (CrimeDetailsRepository crimeDetailsRepository)
    {
        this.crimeDetailsRepository = crimeDetailsRepository;
    }

    public ResponseEntity<Object> newCrimeDetail(CrimeDetails crimeDetails)
    {
        crimeDetailsRepository.save(crimeDetails);
        return new ResponseEntity<>(crimeDetails, HttpStatus.CREATED);
    }

    public List<CrimeDetails> getCrimeDetails()
    {
        return this.crimeDetailsRepository.findAll();
    }

    public ResponseEntity<Object> getCrimeDetailById(Integer id)
    {
        Optional<CrimeDetails> crimeDetailsOptional = crimeDetailsRepository.findById(id);
        if (!crimeDetailsOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        CrimeDetails crimeDetails = crimeDetailsOptional.get();
        return ResponseEntity.ok(crimeDetails);

    }

    public ResponseEntity<Object> updateCrimeDetail(Integer id, CrimeDetails updatedCrimeDetail)
    {
        Optional<CrimeDetails> crimeDetailsOptional = crimeDetailsRepository.findById(id);

        if (!crimeDetailsOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        CrimeDetails existingCrimeDetail = crimeDetailsOptional.get();
        existingCrimeDetail.setInfo(updatedCrimeDetail.getInfo());
        crimeDetailsRepository.save(existingCrimeDetail);
        return ResponseEntity.ok(existingCrimeDetail);
    }
    public ResponseEntity<Object> deleteCrimeDetail(Integer id)
    {
        Optional<CrimeDetails> crimeDetailsOptional = crimeDetailsRepository.findById(id);
        if (!crimeDetailsOptional.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        crimeDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
