package com.example.maping.repository;

import com.example.maping.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ApplicationBaseRepo<T extends Application> extends JpaRepository<T, Long> {
}
