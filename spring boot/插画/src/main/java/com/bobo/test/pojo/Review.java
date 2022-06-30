package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Review {
    private Integer id;
    private Integer userId;
    private Integer ikonId;
    private String context;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime reviewTime;

    public Review() {
    }

    public Review(Integer id, Integer userId, Integer ikonId, String context, LocalDateTime reviewTime) {
        this.id = id;
        this.userId = userId;
        this.ikonId = ikonId;
        this.context = context;
        this.reviewTime = reviewTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIkonId() {
        return ikonId;
    }

    public void setIkonId(Integer ikonId) {
        this.ikonId = ikonId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalDateTime reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId=" + userId +
                ", ikonId=" + ikonId +
                ", context='" + context + '\'' +
                ", reviewTime=" + reviewTime +
                '}';
    }
}
