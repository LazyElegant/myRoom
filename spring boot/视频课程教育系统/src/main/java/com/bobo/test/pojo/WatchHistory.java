package com.bobo.test.pojo;

public class WatchHistory {
    private Long id;
    private Long video_id;
    private Long user_id;
    private String create_time;

    public WatchHistory() {
    }

    public WatchHistory(Long id, Long video_id, Long user_id, String create_time) {
        this.id = id;
        this.video_id = video_id;
        this.user_id = user_id;
        this.create_time = create_time;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "WatchHistory{" +
                "id=" + id +
                ", video_id=" + video_id +
                ", user_id=" + user_id +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
