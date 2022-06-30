package com.bobo.test.vo;

import java.time.LocalDateTime;

public class IkonVo {

    private Integer id;
    private Integer authorId;
    private String author;
    private String title;
    private String pic;
    private String context;
    private LocalDateTime issueTime;
    private String classify;

    public IkonVo() {
    }

    public IkonVo(Integer id, Integer authorId, String author, String title, String pic, String context, LocalDateTime issueTime, String classify) {
        this.id = id;
        this.authorId = authorId;
        this.author = author;
        this.title = title;
        this.pic = pic;
        this.context = context;
        this.issueTime = issueTime;
        this.classify = classify;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Override
    public String toString() {
        return "IkonVo{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", context='" + context + '\'' +
                ", issueTime=" + issueTime +
                ", classify='" + classify + '\'' +
                '}';
    }
}
