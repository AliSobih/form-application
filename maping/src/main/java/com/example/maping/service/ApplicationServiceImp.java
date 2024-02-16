package com.example.maping.service;

import com.example.maping.entity.Application;
import com.example.maping.repository.ApplicationRepo;
import com.example.maping.repository.ReviewRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationServiceImp extends ApplicationBaseService<Application> implements ApplicationService<Application> {

    private final ApplicationRepo applicationRepo;

    public ApplicationServiceImp(ReviewRepo reviewRepo, ApplicationRepo applicationRepo) {
        super(reviewRepo);
        this.applicationRepo = applicationRepo;
    }

    @Override
    @Transactional
    public void save(Application application) {
        super.save(application);
        applicationRepo.save(application);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepo.findAll();
    }

    @Override
    public Application findById(Long id) {
        return applicationRepo.findById(id).orElse(null);
    }
}
