package Entity;

import java.time.LocalDate;

public class Student {
    private Integer sid;
    private String password;
    private String name;
    private String sex;
    private LocalDate dateOfBirth;
    private String college;
    private String major;
    private String stuClass;

    public Student() {
    }

    public Student(Integer sid, String password, String name, String sex, LocalDate dateOfBirth, String college, String major, String stuClass) {
        this.sid = sid;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.college = college;
        this.major = major;
        this.stuClass = stuClass;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public String toString() {
        return  "学生id=" + sid +
                ", 密码='" + password + '\'' +
                ", 姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 出生日期=" + dateOfBirth +
                ", 所在学院='" + college + '\'' +
                ", 专业='" + major + '\'' +
                ", 班级='" + stuClass;
    }
}
