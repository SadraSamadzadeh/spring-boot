package com.example.PoliceApp.Service;


import com.example.PoliceApp.Modal.Officer;
import com.example.PoliceApp.Modal.Reports;
import com.example.PoliceApp.Repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportsService {
    private final ReportsRepository reportsRepository;

    @Autowired
    public ReportsService(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    public ResponseEntity<Object> newReport(Reports reports) {
        reportsRepository.save(reports);
        return new ResponseEntity<>(reports, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateReports(int id, Reports updatedReport) {
        Optional<Reports> reportsOptional = reportsRepository.findById(id);

        if (reportsOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Reports existingReports = reportsOptional.get();
        existingReports.setDetails(updatedReport.getDetails());
        existingReports.setDateReported(updatedReport.getDateReported());
        existingReports.setStatus(updatedReport.getStatus());
        reportsRepository.save(existingReports);
        return ResponseEntity.ok(existingReports);
    }

    public ResponseEntity<Object> deleteReports(int id) {
        Optional<Reports> reportsOptional = reportsRepository.findById(id);
        if (!reportsOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reportsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object> getReportsById(int id) {
        Optional<Reports> reportsOptional = reportsRepository.findById(id);
        if (!reportsOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Reports reports = reportsOptional.get();
        return ResponseEntity.ok(reports);
    }
    public List<Reports> getReports() {
        return this.reportsRepository.findAll();
    }
}

