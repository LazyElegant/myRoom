package com.bobo.test.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ReviewVo {

    private Integer id;
    private String context;
    private String userName;
    private String pic;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime reviewTime;

    public ReviewVo() {
    }

    public ReviewVo(Integer id, String context, String userName, String pic, LocalDateTime reviewTime) {
        this.id = id;
        this.context = context;
        this.userName = userName;
        this.pic = pic;
        this.reviewTime = reviewTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public LocalDateTime getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalDateTime reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public String toString() {
        return "ReviewVo{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", userName='" + userName + '\'' +
                ", pic='" + pic + '\'' +
                ", reviewTime=" + reviewTime +
                '}';
    }
}
