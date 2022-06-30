package com.bobo.test.pojo;

public class science {

    private int id;
    private String illness_name;
    private String Illness_message;
    private int user_id;
    private String illness_photo;

    public science() {
    }

    public science(int id, String illness_name, String illness_message, int user_id, String illness_photo) {
        this.id = id;
        this.illness_name = illness_name;
        Illness_message = illness_message;
        this.user_id = user_id;
        this.illness_photo = illness_photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIllness_name() {
        return illness_name;
    }

    public void setIllness_name(String illness_name) {
        this.illness_name = illness_name;
    }

    public String getIllness_message() {
        return Illness_message;
    }

    public void setIllness_message(String illness_message) {
        Illness_message = illness_message;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getIllness_photo() {
        return illness_photo;
    }

    public void setIllness_photo(String illness_photo) {
        this.illness_photo = illness_photo;
    }

    @Override
    public String toString() {
        return "science{" +
                "id=" + id +
                ", illness_name='" + illness_name + '\'' +
                ", Illness_message='" + Illness_message + '\'' +
                ", user_id=" + user_id +
                ", illness_photo='" + illness_photo + '\'' +
                '}';
    }
}
