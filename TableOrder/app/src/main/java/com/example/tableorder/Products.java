package com.example.tableorder;

public class Products {
    private String name;
    private int price;
    private int actualPrice;
    private String Type;
    private String size;
    private int discount;
    private boolean status;
    public Products(String name, int price,int actualPrice, String Type, int discount, boolean status, String size)
    {
        this.name=name;
        this.price=price;
        this.Type=Type;
        this.actualPrice=actualPrice;
        this.discount=discount;
        this.status=status;
        this.size=size;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", actualPrice=" + actualPrice +
                ", Type='" + Type + '\'' +
                ", discount=" + discount +
                ", status=" + status +
                '}';
    }
}
