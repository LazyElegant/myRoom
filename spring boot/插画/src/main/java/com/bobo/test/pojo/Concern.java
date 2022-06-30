package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Concern {
    private Integer id;
    private Integer userId;
    private Integer concernId;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime concernTime;

    public Concern() {

    }
    public Concern(Integer id, Integer userId, Integer concernId, LocalDateTime concernTime) {
        this.id = id;
        this.userId = userId;
        this.concernId = concernId;
        this.concernTime = concernTime;
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

    public Integer getConcernId() {
        return concernId;
    }

    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
    }

    public LocalDateTime getConcernTime() {
        return concernTime;
    }

    public void setConcernTime(LocalDateTime concernTime) {
        this.concernTime = concernTime;
    }

    @Override
    public String toString() {
        return "Concern{" +
                "id=" + id +
                ", userId=" + userId +
                ", concernId=" + concernId +
                ", concernTime=" + concernTime +
                '}';
    }
}
