package com.bobo.test.pojo;

public class forum {

    private int id;
    private String title;
    private String content;
    private int user_id;
    private String creation_time;

    public forum() {
    }

    public forum(int id, String title, String content, int user_id, String creation_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.creation_time = creation_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    @Override
    public String toString() {
        return "forum{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user_id=" + user_id +
                ", creation_time='" + creation_time + '\'' +
                '}';
    }
}
