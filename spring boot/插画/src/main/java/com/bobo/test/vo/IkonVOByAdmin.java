package com.bobo.test.vo;

import java.time.LocalDateTime;

public class IkonVOByAdmin {
    private Integer id;
    private String title;
    private LocalDateTime issueTime;
    private String author;
    private String pic;
    private String context;
    private String classify;
    private Integer collect;
    private Integer thumb;

    public IkonVOByAdmin() {
    }

    public IkonVOByAdmin(Integer id, String title, LocalDateTime issueTime, String author, String pic, String context, String classify, Integer collect, Integer thumb) {
        this.id = id;
        this.title = title;
        this.issueTime = issueTime;
        this.author = author;
        this.pic = pic;
        this.context = context;
        this.classify = classify;
        this.collect = collect;
        this.thumb = thumb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getThumb() {
        return thumb;
    }

    public void setThumb(Integer thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "IkonVOByAdmin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", issueTime=" + issueTime +
                ", author='" + author + '\'' +
                ", pic='" + pic + '\'' +
                ", context='" + context + '\'' +
                ", classify='" + classify + '\'' +
                ", collect=" + collect +
                ", thumb=" + thumb +
                '}';
    }
}
