package com.cm.model;

/**
 * @Author admin
 * @create 2022/5/18 22:56
 */
public class Classify {
    private Integer id;
    private String name;

    public Classify() {
    }

    public Classify(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
