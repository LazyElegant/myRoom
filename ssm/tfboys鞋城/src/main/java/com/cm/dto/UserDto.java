package com.cm.dto;

/**
 * @Author admin
 * @create 2022/5/19 11:09
 */
public class UserDto {

    private Long id;
    private String password;

    public UserDto() {
    }

    public UserDto(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "UserDto{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
