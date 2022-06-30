package com.cm.model;

public class Foods {

    private Integer id;
    private String name;
    private Double count;
    private String content;

    public Foods() {
    }

    public Foods(Integer id, String name, Double count, String content) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.content = content;
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

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", content='" + content + '\'' +
                '}';
    }
}
