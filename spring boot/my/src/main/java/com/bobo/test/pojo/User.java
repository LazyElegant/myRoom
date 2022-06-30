package com.bobo.test.pojo;

public class User {

    private int user_num;
    private String user_name;
    private String user_password;
    private String user_email;
    private String registration_date;
    private int status;

    public User() {
    }

    public User(int user_num, String user_name, String user_password, String user_email, String registration_date, int status) {
        this.user_num = user_num;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.registration_date = registration_date;
        this.status = status;
    }

    public int getUser_num() {
        return user_num;
    }

    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_num=" + user_num +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
