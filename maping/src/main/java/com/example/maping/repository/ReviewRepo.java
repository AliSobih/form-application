package com.example.maping.repository;

import com.example.maping.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findReviewByApplicationId(Long applicationId);

    void deleteAllByApplicationId(Long id);
}
