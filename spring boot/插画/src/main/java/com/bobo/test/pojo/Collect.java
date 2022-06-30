package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Collect {
    private Integer id;
    private Integer userId;
    private Integer ikonId;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime collectTime;

    public Collect() {
    }

    public Collect(Integer id, Integer userId, Integer ikonId, LocalDateTime collectTime) {
        this.id = id;
        this.userId = userId;
        this.ikonId = ikonId;
        this.collectTime = collectTime;
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

    public LocalDateTime getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(LocalDateTime collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", userId=" + userId +
                ", ikonId=" + ikonId +
                ", collectTime=" + collectTime +
                '}';
    }
}
