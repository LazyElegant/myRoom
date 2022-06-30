package com.bobo.test.pojo;

public class Classes {
    private int ify_num;
    private String ify_name;

    public Classes(){

    }

    public Classes(int ify_num, String ify_name) {
        this.ify_num = ify_num;
        this.ify_name = ify_name;
    }

    public int getIfy_num() {
        return ify_num;
    }

    public void setIfy_num(int ify_num) {
        this.ify_num = ify_num;
    }

    public String getIfy_name() {
        return ify_name;
    }

    public void setIfy_name(String ify_name) {
        this.ify_name = ify_name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "ify_num=" + ify_num +
                ", ify_name='" + ify_name + '\'' +
                '}';
    }
}
