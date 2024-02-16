package com.example.maping.dto;

import lombok.Data;

@Data
public class ReviewRequest {
    private Long applicationId;
    private String role;
    private String decision;
}
