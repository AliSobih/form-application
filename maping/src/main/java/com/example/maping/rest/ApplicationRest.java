package com.example.maping.rest;

import com.example.maping.dto.ApplicationRequest;
import com.example.maping.entity.Application;
import com.example.maping.service.ApplicationServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationRest {
    private final ApplicationServiceImp applicationService;

    @PostMapping
    public ResponseEntity<Void> saveApplication(@RequestBody ApplicationRequest applicationRequest) {
        applicationService.saveApplication(applicationRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Application> findAllApplications() {
        return applicationService.findAllApplications();
    }

    @GetMapping("/{id}")
    public Application showAllApplications(@PathVariable Long id) {
        return applicationService.findApplicationById(id);

    }
}
