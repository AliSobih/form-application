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

    private final JobApplicationRepo jobApplicationRepo;
    private static final List<DepartmentRole> roles = EnumSet.allOf(DepartmentRole.class).stream().toList();

    public JobApplicationServiceImp(ReviewRepo reviewRepo, JobApplicationRepo jobApplicationRepo) {
        super(reviewRepo, roles);
        this.jobApplicationRepo = jobApplicationRepo;
    }

    @Override
    @Transactional
    public void save(JobApplication application) {
        super.save(application);
        jobApplicationRepo.save(application);
    }

    @Override
    public List<JobApplication> findAll() {
        return jobApplicationRepo.findAll();
    }

    @Override
    public JobApplication findById(Long id) {
        return jobApplicationRepo.findById(id).orElse(null);
    }
}
