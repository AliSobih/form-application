package com.example.maping.service;

import com.example.maping.dto.ApplicationRequest;
import com.example.maping.entity.Application;
import com.example.maping.entity.Review;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.repository.ApplicationRepo;
import com.example.maping.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ApplicationServiceImp implements ApplicationService<Application>{
    private final ApplicationRepo applicationRepo;
    private final ReviewRepo reviewRepo;
    @Override
    @Transactional
    public void saveApplication(ApplicationRequest request) {
        Application application = new Application(
                request.firstName,
                request.lastName,
                request.email,
                request.description
        );

        List<DepartmentRole> roleList = EnumSet.allOf(DepartmentRole.class).stream().toList();
        applicationRepo.save(application);
        for (DepartmentRole role : roleList) {
            Review review = new Review(
                    role,
                    application
            );
            reviewRepo.save(review);
        }
    }

    @Override
    public List<Application> findAllApplications() {
        return applicationRepo.findAll();
    }

    @Override
    public Application findApplicationById(Long id) {
        return applicationRepo.findById(id).orElse(null);
    }
}
