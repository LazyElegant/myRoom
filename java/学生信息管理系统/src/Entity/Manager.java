package Entity;

import java.time.LocalDate;

public class Manager {
    private Integer mid;
    private String password;
    private String name;
    private String sex;
    private LocalDate dateOfBirth;


    public Manager() {
    }

    public Manager(Integer mid, String password, String name, String sex, LocalDate dateOfBirth) {
        this.mid = mid;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return  "id=" + mid +
                ", 密码='" + password + '\'' +
                ", 用户名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 出生年月=" + dateOfBirth;
    }
}
