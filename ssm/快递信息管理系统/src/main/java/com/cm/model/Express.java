package com.cm.model;

public class Express {

    private Integer id;
    private Long numbers;
    private String thing;
    private Double weight;
    private String senderName;
    private Long senderPhone;
    private String senderAddress;
    private String addresseeName;
    private Long addresseePhone;
    private String addresseeAddress;
    private Integer status;

    public Express() {
    }

    public Express(Integer id, Long numbers, String thing, Double weight, String senderName, Long senderPhone, String senderAddress, String addresseeName, Long addresseePhone, String addresseeAddress, Integer status) {
        this.id = id;
        this.numbers = numbers;
        this.thing = thing;
        this.weight = weight;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.addresseeName = addresseeName;
        this.addresseePhone = addresseePhone;
        this.addresseeAddress = addresseeAddress;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Long getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(Long senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public Long getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(Long addresseePhone) {
        this.addresseePhone = addresseePhone;
    }

    public String getAddresseeAddress() {
        return addresseeAddress;
    }

    public void setAddresseeAddress(String addresseeAddress) {
        this.addresseeAddress = addresseeAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Express{" +
                "id=" + id +
                ", numbers=" + numbers +
                ", thing='" + thing + '\'' +
                ", weight=" + weight +
                ", senderName='" + senderName + '\'' +
                ", senderPhone=" + senderPhone +
                ", senderAddress='" + senderAddress + '\'' +
                ", addresseeName='" + addresseeName + '\'' +
                ", addresseePhone=" + addresseePhone +
                ", addresseeAddress='" + addresseeAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
