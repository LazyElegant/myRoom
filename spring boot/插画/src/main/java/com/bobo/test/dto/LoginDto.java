package com.bobo.test.dto;

public class LoginDto {
    private Integer id;
    private String password;

    public LoginDto(Integer id, String password) {
        this.id = id;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
