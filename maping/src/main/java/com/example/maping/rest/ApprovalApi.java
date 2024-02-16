package com.example.maping.rest;

import com.example.maping.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/approval")
@RequiredArgsConstructor
public class ApprovalApi {
    private final ApprovalService approvalService;

    @PostMapping("/approve/{reviewId}")
    public void approve(@PathVariable("reviewId") Long reviewId) throws Exception {
        approvalService.approve(reviewId);
    }

    @PostMapping("/reject/{reviewId}")
    public void reject(@PathVariable("reviewId") Long reviewId) throws Exception {
        approvalService.reject(reviewId);
    }
}
