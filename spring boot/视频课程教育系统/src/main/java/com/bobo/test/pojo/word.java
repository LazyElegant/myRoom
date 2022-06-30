package com.bobo.test.pojo;

/**
 * @Author admin
 * @create 2021/5/2 14:40
 */
public class word {

    private Long id;
    private String path;
    private Long video_id;
    private Long user_id;

    public word() {
    }

    public word(Long id, String path, Long video_id, Long user_id) {
        this.id = id;
        this.path = path;
        this.video_id = video_id;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    @Override
    public String toString() {
        return "word{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", video_id=" + video_id +
                ", user_id=" + user_id +
                '}';
    }
}
