package com.bobo.test.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class PainterVo {

    private Integer id;
    private Integer painterId;
    private String name;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime registrationTime;
    private Integer status;

    public PainterVo() {
    }

    public PainterVo(Integer id, Integer painterId, String name, LocalDateTime registrationTime, Integer status) {
        this.id = id;
        this.painterId = painterId;
        this.name = name;
        this.registrationTime = registrationTime;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPainterId() {
        return painterId;
    }

    public void setPainterId(Integer painterId) {
        this.painterId = painterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PainterVo{" +
                "id=" + id +
                ", painterId=" + painterId +
                ", name='" + name + '\'' +
                ", registrationTime=" + registrationTime +
                ", status=" + status +
                '}';
    }
}
