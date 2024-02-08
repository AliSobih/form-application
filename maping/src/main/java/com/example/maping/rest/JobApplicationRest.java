package com.example.maping.rest;

import com.example.maping.dto.ApplicationRequest;
import com.example.maping.entity.Application;
import com.example.maping.entity.JobApplication;
import com.example.maping.service.JobApplicationServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-application")
@RequiredArgsConstructor
public class JobApplicationRest {
    private final JobApplicationServiceImp jobApplicationService;

    @PostMapping
    public ResponseEntity<Void> saveApplication(@RequestBody ApplicationRequest applicationRequest) {
        jobApplicationService.saveApplication(applicationRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public List<JobApplication> findAllApplications() {
        return jobApplicationService.findAllApplications();
    }

    @GetMapping("/{id}")
    public JobApplication showAllApplications(@PathVariable Long id) {
        return jobApplicationService.findApplicationById(id);

    }
}
