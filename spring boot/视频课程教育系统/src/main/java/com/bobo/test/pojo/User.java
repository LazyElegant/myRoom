package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private String name;
    private String password;

    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    private String email;
    private String photo;
    private Integer power;

    private Long specialty_id;

    public User() {
    }

    public User(Long id, String name, String password, LocalDateTime createTime, String email, String photo, Integer power, Long specialty_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createTime = createTime;
        this.email = email;
        this.photo = photo;
        this.power = power;
        this.specialty_id = specialty_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Long getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Long specialty_id) {
        this.specialty_id = specialty_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", power=" + power +
                ", specialty_id=" + specialty_id +
                '}';
    }
}