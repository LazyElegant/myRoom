package com.bobo.test.pojo;

public class Reply {
    private Long id;
    private Long point;
    private String context;
    private String creation_time;
    private Long user_id;
    private Long comment_id;

    public Reply() {
    }

    public Reply(Long id, Long point, String context, String creation_time, Long user_id, Long comment_id) {
        this.id = id;
        this.point = point;
        this.context = context;
        this.creation_time = creation_time;
        this.user_id = user_id;
        this.comment_id = comment_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", point=" + point +
                ", context='" + context + '\'' +
                ", creation_time='" + creation_time + '\'' +
                ", user_id=" + user_id +
                ", comment_id=" + comment_id +
                '}';
    }
}
