package pojo;

public class Students {
    private int id;
    private String name;
    private int age;
    private String number;
    private String sex;

    public Students() {
    }

    public Students(int id, String name, int age, String number, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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
        return "Studnets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
