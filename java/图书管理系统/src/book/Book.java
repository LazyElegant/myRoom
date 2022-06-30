package book;

/**
 * 图书类
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Double price;
    private String type;
    private Integer number;

    public Book() {
    }

    public Book(Integer id, String name, String author, Double price, String type, Integer number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.number = number;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", author=" + author +
                ", price=" + price +
                ", type=" + type+
                ", number=" + number;
    }
}
