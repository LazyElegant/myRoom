package com.bobo.test.pojo;

/**
 * @Author admin
 * @create 2021/5/2 14:01
 */
public class courseware {
    private Long id;
    private String path;
    private Long video_id;

    public courseware() {
    }

    public courseware(Long id, String path, Long video_id) {
        this.id = id;
        this.path = path;
        this.video_id = video_id;
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

    @Override
    public String toString() {
        return "courseware{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", video_id=" + video_id +
                '}';
    }
}
