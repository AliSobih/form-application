package com.example.maping.service;

import com.example.maping.entity.Application;
import com.example.maping.entity.Review;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class ApplicationBaseService<T extends Application> implements ApplicationService<T> {
    private final ReviewRepo reviewRepo;
    private final List<DepartmentRole> roles;

    @Override
    public void save(T application) {
        List<Review> reviews = new ArrayList<>();
        for (DepartmentRole role : roles) {
            Review review = new Review(
                    role,
                    application
            );
            reviews.add(review);
        }
        reviewRepo.saveAll(reviews);
    }
}
