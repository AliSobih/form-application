package com.example.maping.service;

import com.example.maping.dto.ReviewRequest;
import com.example.maping.entity.Group;

public interface GroupService {
    void makeDecision(ReviewRequest request);
    void addGroup(Group group);
}
