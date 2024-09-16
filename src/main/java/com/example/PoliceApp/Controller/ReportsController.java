package com.example.PoliceApp.Controller;


import com.example.PoliceApp.Modal.Reports;
import com.example.PoliceApp.Service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportsController {

    private final ReportsService reportsService;

    @Autowired
    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createReport (@RequestBody Reports report)
    {
        return this.reportsService.newReport(report);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateReportById(@PathVariable int id, @RequestBody Reports report)
    {
        return this.reportsService.updateReports(id, report);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteReport(@PathVariable int id)
    {
        return this.reportsService.deleteReports(id);
    }

    @GetMapping("/get")
    public List<Reports> getAllReports(){
        return this.reportsService.getReports();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getReportById(@PathVariable int id)
    {
        return this.reportsService.getReportsById(id);
    }
}
