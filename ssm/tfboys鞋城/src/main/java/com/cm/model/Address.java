package com.cm.model;

/**
 * @Author admin
 * @create 2022/5/19 22:58
 */
public class Address {

    private Integer id;
    private Integer userId;
    private String address;
    private Integer status;

    public Address() {
    }

    public Address(Integer id, Integer userId, String address, Integer status) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
