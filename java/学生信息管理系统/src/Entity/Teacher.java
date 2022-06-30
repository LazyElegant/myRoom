package Entity;

import java.time.LocalDate;

public class Teacher {
    private Integer tid;
    private String password;
    private String name;
    private String sex;
    private LocalDate dateOfBirth;
    private String college;
    private String course;
    private String email;

    public Teacher() {
    }

    public Teacher(Integer tid, String password, String name, String sex, LocalDate dateOfBirth, String college, String course, String email) {
        this.tid = tid;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.college = college;
        this.course = course;
        this.email = email;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "教师id=" + tid +
                ", 密码='" + password + '\'' +
                ", 用户名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 出生年月=" + dateOfBirth +
                ", 所在学校='" + college + '\'' +
                ", 主讲课程='" + course + '\'' +
                ", 邮箱='" + email ;
    }
}
