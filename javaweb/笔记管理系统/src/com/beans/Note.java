package com.beans;

public class Note {
    private Integer id;
    private Integer classifyId;
    private String title;
    private String content;
    private String date;
    private Integer userId;

    public Note() {
    }

    public Note(Integer id, Integer classifyId, String title, String content, String date,Integer userId) {
        this.id = id;
        this.classifyId = classifyId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
