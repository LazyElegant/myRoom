package com.cm.model;

/**
 * @Author admin
 * @create 2022/5/25 11:10
 */
public class Goods {

    private Integer id;
    private String name;
    private Double price;
    private String content;

    public Goods() {
    }

    public Goods(Integer id, String name, Double price, String content) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                '}';
    }
}
