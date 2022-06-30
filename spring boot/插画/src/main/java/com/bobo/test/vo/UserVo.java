package com.bobo.test.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class UserVo {
    private Integer id;
    private Integer painterId;
    private String name;
    private String password;
    private String email;
    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime registrationTime;
    private String status;
    private String pic;

    public UserVo() {
    }

    public UserVo(Integer id, Integer painterId, String name, String password, String email, LocalDateTime registrationTime, String status, String pic) {
        this.id = id;
        this.painterId = painterId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.registrationTime = registrationTime;
        this.status = status;
        this.pic = pic;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", painterId=" + painterId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registrationTime=" + registrationTime +
                ", status='" + status + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
