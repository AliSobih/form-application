package com.example.maping.repository;

import com.example.maping.entity.Review;
import com.example.maping.enumPackage.DepartmentRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
//    @Query("select r FROM Review r WHERE r.application.id = :appId AND r.role = :role")
//    Optional<Review> findReviewByApplicationIdAndRole(Long applicationId, DepartmentRole role);

    @Query("SELECT r FROM Review r WHERE r.application.id = ?1 ")
    @Modifying
    List<Review> findReviewByApplicationId(Long applicationId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Review r WHERE r.application.id = :appId AND r.role = :role")
    void deleteReviewByApplicationAndRole(
            @Param("appId") Long appId,
            @Param("role") DepartmentRole role);
}
