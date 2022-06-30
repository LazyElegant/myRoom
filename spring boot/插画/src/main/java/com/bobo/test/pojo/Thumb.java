package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Thumb {
    private Integer id;
    private Integer userId;
    private Integer ikonId;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime thumbTime;

    public Thumb() {
    }

    public Thumb(Integer id, Integer userId, Integer ikonId, LocalDateTime thumbTime) {
        this.id = id;
        this.userId = userId;
        this.ikonId = ikonId;
        this.thumbTime = thumbTime;
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

    public LocalDateTime getThumbTime() {
        return thumbTime;
    }

    public void setThumbTime(LocalDateTime thumbTime) {
        this.thumbTime = thumbTime;
    }

    @Override
    public String toString() {
        return "Thumb{" +
                "id=" + id +
                ", userId=" + userId +
                ", ikonId=" + ikonId +
                ", thumbTime=" + thumbTime +
                '}';
    }
}
