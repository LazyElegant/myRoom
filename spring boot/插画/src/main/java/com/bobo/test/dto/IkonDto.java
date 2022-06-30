package com.bobo.test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class IkonDto {

    private Integer id;
    private Integer classifyId;
    private String title;
    private MultipartFile pictures;
    private String pic;
    private Integer authorId;
    private String context;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime issueTime;

    public IkonDto() {
    }

    public IkonDto(Integer id, Integer classifyId, String title, MultipartFile pictures, String pic, Integer authorId, String context, LocalDateTime issueTime) {
        this.id = id;
        this.classifyId = classifyId;
        this.title = title;
        this.pictures = pictures;
        this.pic = pic;
        this.authorId = authorId;
        this.context = context;
        this.issueTime = issueTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public void setPictures(MultipartFile pictures) {
        this.pictures = pictures;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    @Override
    public String toString() {
        return "IkonDto{" +
                "id=" + id +
                ", classifyId=" + classifyId +
                ", title='" + title + '\'' +
                ", pictures=" + pictures +
                ", pic='" + pic + '\'' +
                ", authorId=" + authorId +
                ", context='" + context + '\'' +
                ", issueTime=" + issueTime +
                '}';
    }
}
