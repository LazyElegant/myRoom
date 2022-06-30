package com.bobo.test.pojo;

public class comment {
    private int id;
    private int forum_id;
    private int user_id;
    private String creation_time;
    private String content;

    public comment(){

    }

    public comment(int id, int forum_id, int user_id, String creation_time, String content) {
        this.id = id;
        this.forum_id = forum_id;
        this.user_id = user_id;
        this.creation_time = creation_time;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "comment{" +
                "id=" + id +
                ", forum_id=" + forum_id +
                ", user_id=" + user_id +
                ", creation_time='" + creation_time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
