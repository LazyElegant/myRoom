package com.beans;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer state;

    public User() {
    }

    public User(Integer id, String username, String password, Integer state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
