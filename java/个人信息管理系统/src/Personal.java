
public class Personal {
    private Integer id;
    private String name;
    private Long number;
    private String address;
    private String email;

    public Personal() {
    }

    public Personal(Integer id, String name, Long number, String address, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", number=" + number +
                ", address=" + address +
                ", email=" + email ;
    }
}
