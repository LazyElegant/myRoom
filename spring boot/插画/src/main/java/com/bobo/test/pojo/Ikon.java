package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Ikon {

    private Integer id;
    private Integer classifyId;
    private String title;
    private String pic;
    private Integer authorId;
    private String context;

    @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime issueTime;

    public Ikon() {
    }

    public Ikon(Integer id, Integer classifyId, String title, String pic, Integer authorId, String context, LocalDateTime issueTime) {
        this.id = id;
        this.classifyId = classifyId;
        this.title = title;
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
        return "Ikon{" +
                "id=" + id +
                ", classifyId=" + classifyId +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", authorId=" + authorId +
                ", context='" + context + '\'' +
                ", issueTime=" + issueTime +
                '}';
    }
}
