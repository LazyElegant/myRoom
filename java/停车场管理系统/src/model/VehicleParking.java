package model;

public class VehicleParking {
    private Integer id;
    private String number;
    /**
     * 车辆类型 1：中小型车辆 2：大型车 3：新能源车
     */
    private Integer type;
    /**
     * 是否为包月车 1: 是 2：否
     */
    private Integer month;

    private String startDate;

    private String endDate;

    private Integer price;
    /**
     * 是否在场 1: 是 2：否
     */
    private Integer present;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPresent() {
        return present;
    }

    public void setPresent(Integer present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", number=" + number +
                ", type=" + type +
                ", month=" + month +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", present=" + present;
    }
}
