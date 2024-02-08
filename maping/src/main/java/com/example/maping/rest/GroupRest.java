package com.example.maping.rest;

import com.example.maping.dto.AddGroup;
import com.example.maping.dto.ReviewRequest;
import com.example.maping.entity.Group;
import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.service.GroupServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupRest {
    private final GroupServiceImp groupService;

    @PostMapping("/decision")
    public void makeDecision(@RequestBody ReviewRequest request) {
        groupService.makeDecision(request);
    }
    @PostMapping
    public void AddGroup(AddGroup group) {
        Group group1 = new Group(group.email, DepartmentRole.valueOf(group.role.trim()));
        groupService.addGroup(group1);
    }
}
