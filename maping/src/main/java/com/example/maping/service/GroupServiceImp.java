package com.example.maping.service;

import com.example.maping.entity.Group;
import com.example.maping.repository.GroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImp implements GroupService {
    private final GroupRepo groupRepo;

    @Override
    public void addGroup(Group group) {
        groupRepo.save(group);
    }

}
