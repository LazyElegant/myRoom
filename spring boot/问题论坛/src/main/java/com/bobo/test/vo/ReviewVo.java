package com.bobo.test.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ReviewVo {

    private Integer id;
    private String userName;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime reviewTime;
    private String context;

    public ReviewVo() {
    }

    public ReviewVo(Integer id, String userName, LocalDateTime reviewTime, String context) {
        this.id = id;
        this.userName = userName;
        this.reviewTime = reviewTime;
        this.context = context;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "ReviewVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", reviewTime=" + reviewTime +
                ", context='" + context + '\'' +
                '}';
    }
}
