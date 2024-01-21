package com.example.demo.rest;

import com.example.demo.dto.ReviewRequest;
import com.example.demo.service.InterviewGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class InterviewGroupRest {
    private final InterviewGroupService interviewGroupService;

    @PostMapping
    public void makeDecision(@Valid @RequestBody ReviewRequest request) {
        interviewGroupService.makeDecision(request);
    }
}
