package com.example.PoliceApp.Service;


import com.example.PoliceApp.Modal.Reporter;
import com.example.PoliceApp.Modal.Reports;
import com.example.PoliceApp.Repository.ReporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporterService {

    private final ReporterRepository reporterRepository;

    @Autowired
    public ReporterService(ReporterRepository reporterRepository) {
        this.reporterRepository = reporterRepository;
    }

    public ResponseEntity<Object> newReporter(Reporter reporter) {
        reporterRepository.save(reporter);
        return new ResponseEntity<>(reporter, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteReporter(int id, Reporter reporter) {
        Optional<Reporter> reporterOptional = reporterRepository.findById(id);
        if(reporterOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reporterRepository.delete(reporter);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<Object> updateReporter(int id, Reporter updatedReporter) {
        Optional<Reporter> reporterOptional = reporterRepository.findById(id);
        if(reporterOptional.isPresent()) {
            Reporter reporterDB = reporterOptional.get();
        }

        Reporter existingReporter = reporterOptional.get();
        existingReporter.setInfo(updatedReporter.getInfo());
        existingReporter.setUsername(updatedReporter.getUsername());
        reporterRepository.save(existingReporter);
        return ResponseEntity.ok(existingReporter);
    }

    public List<Reporter> getAllReporters() {
        return this.reporterRepository.findAll();
    }

    public ResponseEntity<Object> getReporterById(int id) {
        Optional<Reporter> reporterOptional = reporterRepository.findById(id);
        if(reporterOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Reporter reporter = reporterOptional.get();
        return ResponseEntity.ok(reporter);
    }

}
