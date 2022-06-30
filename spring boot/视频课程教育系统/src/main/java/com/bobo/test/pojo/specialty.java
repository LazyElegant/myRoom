package com.bobo.test.pojo;

public class specialty {
    private Long id;
    private String name;
    private String creation_time;

    public specialty() {
    }

    public specialty(Long id, String name, String creation_time) {
        this.id = id;
        this.name = name;
        this.creation_time = creation_time;
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

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    @Override
    public String toString() {
        return "specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation_time='" + creation_time + '\'' +
                '}';
    }
}
