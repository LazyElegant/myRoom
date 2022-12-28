package com.cm.model;

public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private Integer number;
    private String sex;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer number, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.sex = sex;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", sex='" + sex + '\'' +
                '}';
    }
}
