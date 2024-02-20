package com.example.maping.service;

public interface ApprovalService {

    void approve(Long reviewId) throws Exception;

    void reject(Long reviewId) throws Exception;

}
