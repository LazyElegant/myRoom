package com.vo;

public class NoteVo {
    private Integer id;
    private String classify;
    private String title;
    private String content;
    private String date;

    public NoteVo() {
    }

    public NoteVo(Integer id, String classify, String title, String content, String date) {
        this.id = id;
        this.classify = classify;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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


}
