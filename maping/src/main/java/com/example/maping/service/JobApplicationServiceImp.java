package com.example.maping.service;

import com.example.maping.dto.ApplicationRequest;
import com.example.maping.entity.JobApplication;
import com.example.maping.entity.Review;
import com.example.maping.entity.Skill;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.repository.JobApplicationRepo;
import com.example.maping.repository.ReviewRepo;
import com.example.maping.repository.SkillRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationServiceImp implements ApplicationService<JobApplication> {
    private final JobApplicationRepo jobApplicationRepo;
    private final ReviewRepo reviewRepo;
    private final SkillRepo skillRepo;
    @Override
    public void saveApplication(ApplicationRequest request) {
        JobApplication application = new JobApplication(
                request.firstName,
                request.lastName,
                request.email,
                request.description
        );

        List<Skill> skillList = skillRepo.findAllById(request.skillList);
        application.setSkills(skillList);
        jobApplicationRepo.save(application);

        List<DepartmentRole> roleList = EnumSet.allOf(DepartmentRole.class).stream().toList();
        for (DepartmentRole role : roleList) {
            Review review = new Review(
                    role,
                    application
            );
            reviewRepo.save(review);
        }
    }

    @Override
    public List<JobApplication> findAllApplications() {
        return jobApplicationRepo.findAll();
    }

    @Override
    public JobApplication findApplicationById(Long id) {
        return jobApplicationRepo.findById(id).orElse(null);
    }
}
