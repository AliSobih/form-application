package com.example.maping.service;

import com.example.maping.entity.Application;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.repository.ApplicationRepo;
import com.example.maping.repository.ReviewRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;
import java.util.List;

@Service
public class ApplicationServiceImp extends ApplicationBaseService<Application> implements ApplicationService<Application> {

    private static final List<DepartmentRole> roles = EnumSet.allOf(DepartmentRole.class).stream().toList();


    public ApplicationServiceImp(ReviewRepo reviewRepo, ApplicationRepo applicationRepo) {
        super(reviewRepo, applicationRepo, roles);
    }
}
