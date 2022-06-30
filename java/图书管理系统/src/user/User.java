package user;

/**
 * 用户类
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    /**
     * 用户权限 1：管理员 2：用户
     */
    private Integer status;

    public User() {
    }

    public User(Integer id, String name, String password, Integer status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", status=" + status;
    }
}
