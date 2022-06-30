package com.bobo.test.pojo;

public class comment {
    private Long id;
    private Long video_id;
    private Long user_id;
    private String creation_time;
    private String content;

    public comment(){

    }

    public comment(Long id, Long video_id, Long user_id, String creation_time, String content) {
        this.id = id;
        this.video_id = video_id;
        this.user_id = user_id;
        this.creation_time = creation_time;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
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
                ", video_id=" + video_id +
                ", user_id=" + user_id +
                ", creation_time='" + creation_time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
