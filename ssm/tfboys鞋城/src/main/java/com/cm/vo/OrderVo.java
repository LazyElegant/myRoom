package com.cm.vo;

/**
 * @Author admin
 * @create 2022/5/21 23:46
 */
public class OrderVo {
    private Integer id;
    private String imgUrl;
    private String name;
    private Integer size;
    private Double money;
    private Integer amount;
    private Integer status;
    private String address;

    public OrderVo() {
    }

    public OrderVo(Integer id, String imgUrl, String name, Integer size, Double money, Integer amount, Integer status, String address) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.size = size;
        this.money = money;
        this.amount = amount;
        this.status = status;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", money=" + money +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
