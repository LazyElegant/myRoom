package com.cm.model;

public class Hotel {

    private Integer id;
    private String name;
    private String address;
    private String principal;
    private Long phone;

    public Hotel() {
    }

    public Hotel(Integer id, String name, String address, String principal, Long phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.principal = principal;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", principal='" + principal + '\'' +
                ", phone=" + phone +
                '}';
    }
}
