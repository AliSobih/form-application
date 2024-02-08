package com.example.maping.service;

import com.example.maping.dto.ApplicationRequest;
import com.example.maping.entity.Application;

import java.util.List;

public interface ApplicationService<T extends Application> {
    void saveApplication(ApplicationRequest request);
    List<T> findAllApplications();
    T findApplicationById(Long id);
}
