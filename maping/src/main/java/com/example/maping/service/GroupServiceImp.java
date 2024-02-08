package com.example.maping.service;

import com.example.maping.dto.ReviewRequest;
import com.example.maping.entity.Application;
import com.example.maping.entity.Group;
import com.example.maping.entity.Review;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.enumPackage.Status;
import com.example.maping.repository.ApplicationRepo;
import com.example.maping.repository.GroupRepo;
import com.example.maping.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImp implements GroupService{
    private final GroupRepo groupRepo;
    private final ReviewRepo reviewRepo;
    private final ApplicationRepo applicationRepo;
    @Override
    @Transactional
    public void makeDecision(ReviewRequest request) {
        Application application = applicationRepo.findById(request.applicationId).orElse(null);

        if (application != null) {
            if (request.decision.trim().equalsIgnoreCase(Status.REJECT.toString())) {
                application.setStatus(Status.REJECT);
                reviewRepo.findReviewByApplicationId(request.applicationId)
                        .forEach(reviewRepo::delete);

            }

            if (request.decision.trim().equalsIgnoreCase(Status.ACCEPT.toString())) {
                List<Review> reviews = reviewRepo.findReviewByApplicationId(request.applicationId);
                if (reviews.size() == 1) {
                    application.setStatus(Status.ACCEPT);
                }

                reviewRepo.deleteReviewByApplicationAndRole(
                        request.applicationId,
                        DepartmentRole.valueOf(request.role.trim().toUpperCase())
                );
            }
        }
    }

    @Override
    public void addGroup(Group group) {
        groupRepo.save(group);
    }

}
