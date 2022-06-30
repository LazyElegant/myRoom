package com.bobo.test.pojo;

import javax.persistence.Column;

public class classes {
    private Long id;
    private String name;
    private Long specialty_id;
    private String introduce;
    private Long user_id;
    private String duration;
    private Long watch;
    private String photo;
    private Integer num;

    public classes() {
    }

    public classes(Long id, String name, Long specialty_id, String introduce, Long user_id, String duration, Long watch, String photo, Integer num) {
        this.id = id;
        this.name = name;
        this.specialty_id = specialty_id;
        this.introduce = introduce;
        this.user_id = user_id;
        this.duration = duration;
        this.watch = watch;
        this.photo = photo;
        this.num = num;
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

    public Long getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Long specialty_id) {
        this.specialty_id = specialty_id;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty_id=" + specialty_id +
                ", introduce='" + introduce + '\'' +
                ", user_id=" + user_id +
                ", duration='" + duration + '\'' +
                ", watch=" + watch +
                ", photo='" + photo + '\'' +
                ", num=" + num +
                '}';
    }
}
