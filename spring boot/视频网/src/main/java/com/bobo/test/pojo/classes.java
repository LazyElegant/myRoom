package com.bobo.test.pojo;

import javax.persistence.Column;

public class classes {
    private Long id;
    private String name;
    private Long classify_id;
    private String introduce;
    private Long user_id;
    private String duration;
    private Long watch;
    private String photo;

    public classes() {
    }

    public classes(Long id, String name, Long classify_id, String introduce, Long user_id, String duration, Long watch, String photo) {
        this.id = id;
        this.name = name;
        this.classify_id = classify_id;
        this.introduce = introduce;
        this.user_id = user_id;
        this.duration = duration;
        this.watch = watch;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassify_id() {
        return classify_id;
    }

    public void setClassify_id(Long classify_id) {
        this.classify_id = classify_id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getWatch() {
        return watch;
    }

    public void setWatch(Long watch) {
        this.watch = watch;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classify_id=" + classify_id +
                ", introduce='" + introduce + '\'' +
                ", user_id=" + user_id +
                ", duration='" + duration + '\'' +
                ", watch=" + watch +
                ", photo='" + photo + '\'' +
                '}';
    }
}
