package com.example.PoliceApp.Controller;

import com.example.PoliceApp.Modal.Reporter;
import com.example.PoliceApp.Service.ReporterService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reporter")
public class ReporterController {
    private final ReporterService reporterService;


    @Autowired
    public ReporterController(ReporterService reporterService) {
        this.reporterService = reporterService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createReporter (@RequestBody Reporter reporter)
    {
        return this.reporterService.newReporter(reporter);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateReporterById(@PathVariable int id, @RequestBody Reporter reporter)
    {
        return this.reporterService.updateReporter(id, reporter);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteReporterById (@PathVariable int id)
    {
        return this.deleteReporterById(id);
    }

    @GetMapping("/get")
    public List<Reporter> getAllReporters()
    {
        return this.reporterService.getAllReporters();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getReporterbById(@PathVariable int id)
    {
        return this.getReporterbById(id);
    }
}
