package com.bobo.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Video {
    private Long id;
    private Long classes_id;
    private String create_time;
    private String video_path;
    private String video_name;
    private String video_introduce;

    public Video() {
    }

    public Video(Long id, Long classes_id, String create_time, String video_path, String video_name, String video_introduce) {
        this.id = id;
        this.classes_id = classes_id;
        this.create_time = create_time;
        this.video_path = video_path;
        this.video_name = video_name;
        this.video_introduce = video_introduce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(Long classes_id) {
        this.classes_id = classes_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_introduce() {
        return video_introduce;
    }

    public void setVideo_introduce(String video_introduce) {
        this.video_introduce = video_introduce;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", classes_id=" + classes_id +
                ", create_time='" + create_time + '\'' +
                ", video_path='" + video_path + '\'' +
                ", video_name='" + video_name + '\'' +
                ", video_introduce='" + video_introduce + '\'' +
                '}';
    }
}
