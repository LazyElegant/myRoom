package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Review {

    private Integer id;
    private Integer issueId;
    private Integer userId;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime reviewTime;
    private String context;
    private Integer status;

    public Review() {
    }

    public Review(Integer id, Integer issueId, Integer userId, LocalDateTime reviewTime, String context, Integer status) {
        this.id = id;
        this.issueId = issueId;
        this.userId = userId;
        this.reviewTime = reviewTime;
        this.context = context;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalDateTime reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", issueId=" + issueId +
                ", userId=" + userId +
                ", reviewTime=" + reviewTime +
                ", context='" + context + '\'' +
                ", status=" + status +
                '}';
    }
}
