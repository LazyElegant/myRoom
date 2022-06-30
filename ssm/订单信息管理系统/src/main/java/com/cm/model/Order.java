package com.cm.model;

public class Order {

    private Integer id;
    private String name;
    private Integer count;
    private Double amount;
    private String content;

    public Order() {
    }

    public Order(Integer id, String name, Integer count, Double amount, String content) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.amount = amount;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", amount=" + amount +
                ", content='" + content + '\'' +
                '}';
    }
}
