package com.example.maping.service;

import com.example.maping.entity.Application;
import com.example.maping.entity.Review;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.repository.ApplicationBaseRepo;
import com.example.maping.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ApplicationBaseService<T extends Application> implements ApplicationService<T> {
    private final ReviewRepo reviewRepo;
    private final ApplicationBaseRepo<T> applicationBaseRepo;
    private final List<DepartmentRole> roles;

    @Override
    public void save(T application) {
        List<Review> reviews = new ArrayList<>();
        for (DepartmentRole role : roles) {
            Review review = new Review(role, application);
            reviews.add(review);
        }
        applicationBaseRepo.save(application);
        reviewRepo.saveAll(reviews);
    }

    @Override
    public List<T> findAll() {
        return applicationBaseRepo.findAll();
    }

    @Override
    public T findById(Long id) throws Exception {
        return applicationBaseRepo.findById(id)
                .orElseThrow(() -> new Exception(String.format("No Application Exists with id: %s", id)));
    }
}
