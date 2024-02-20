package com.example.maping.service;

import com.example.maping.entity.Application;
import com.example.maping.entity.Review;
import com.example.maping.enumPackage.Status;
import com.example.maping.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ReviewRepo reviewRepo;

    @Override
    @Transactional
    public void approve(Long reviewId) throws Exception {
        Review review = reviewRepo.findById(reviewId).orElseThrow(() -> new Exception(String.format("No Review With Id: %s", reviewId)));
        Application application = review.getApplication();
        review.setStatus(Status.ACCEPTED);

        List<Review> reviews = reviewRepo.findReviewByApplicationId(application.getId());
        if (reviews.size() == 1) {
            application.setStatus(Status.ACCEPTED);
        }

        reviewRepo.deleteById(reviewId);

    }

    @Override
    @Transactional
    public void reject(Long reviewId) throws Exception {
        Review review = reviewRepo.findById(reviewId).orElseThrow(() -> new Exception(String.format("No Review With Id: %s", reviewId)));
        Application application = review.getApplication();
        application.setStatus(Status.REJECTED);
        reviewRepo.deleteAllByApplicationId(application.getId());
    }
}
