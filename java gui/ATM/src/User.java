
public class User {
    private Long number;
    private String password;
    private Float balance;

    public User() {
    }

    public User(Long number, String password, Float balance) {
        this.number = number;
        this.password = password;
        this.balance = balance;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
