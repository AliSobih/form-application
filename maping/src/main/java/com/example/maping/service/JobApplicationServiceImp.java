package com.example.maping.service;

import com.example.maping.entity.JobApplication;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.repository.JobApplicationRepo;
import com.example.maping.repository.ReviewRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.List;

@Service
public class JobApplicationServiceImp extends ApplicationBaseService<JobApplication> implements ApplicationService<JobApplication> {

    private static final List<DepartmentRole> roles = EnumSet.allOf(DepartmentRole.class).stream().toList();

    public JobApplicationServiceImp(ReviewRepo reviewRepo, JobApplicationRepo jobApplicationRepo) {
        super(reviewRepo, jobApplicationRepo, roles);
    }
}
