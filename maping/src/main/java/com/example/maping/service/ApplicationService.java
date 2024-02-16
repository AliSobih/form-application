package com.example.maping.service;

import com.example.maping.entity.Application;

import java.util.List;

public interface ApplicationService<T extends Application> {
    void save(T request);

    List<T> findAll();

    T findById(Long id);
}
